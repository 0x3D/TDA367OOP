package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.SelectedToolObserver;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.toolModel.Tool;
import com.teamjeaa.obpaint.view.JavaFXDrawVisitor;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class provides a controller for the painting area
 *
 * <p>This class sets up our DrawVisitor and provides the code to render Responsibility The class
 * implements the interfaces Initializable and Observer and is used by canvasView.fxml
 *
 * @author Jonas N
 * @since 0.1-SNAPSHOT
 */
public final class CanvasController implements Initializable, SelectedToolObserver {
  private @FXML BorderPane rootBorderPane;
  private Model backend;
  private Tool selectedTool;
  private JavaFXDrawVisitor javaFXDrawVisitor;

  /**
   * This method initializes the controller for CanvasView
   *
   * @param location - The location used to resolve relative paths for the root object
   * @param resources - The resources used to localize the root object
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    backend = Model.INSTANCE;
    selectedTool = backend.getSelectedTool();
    backend.addObserver(this);
    initMouseActions();
    javaFXDrawVisitor = new JavaFXDrawVisitor(rootBorderPane);
    AnimationTimer animationTimer =
        new AnimationTimer() {
          public void handle(long now) {
            render();
          }
        };
    animationTimer.start();
  }

  private void render() {
    rootBorderPane.getChildren().clear();

    for (Mshape s : backend.getCanvasShapes()) {
      // It wants the old one to be removed if already is a child.
      s.acceptDrawVisitor(javaFXDrawVisitor);
    }
  }

  /**
   * Used by the model through Observer interface to notify all observers that the selected tool has
   * changed
   */
  @Override
  public void selectedToolHasChanged() {
    selectedTool = backend.getSelectedTool();
  }

  private void initMouseActions() {
    //    rootBorderPane.setOnMouseClicked(
    //      mouseEvent -> initialMouseClick(mouseEvent.getX(), mouseEvent.getY()));
    rootBorderPane.setOnMousePressed(
        mouseEvent -> {
          selectedTool.startUse(mouseEvent.getX(), mouseEvent.getY());
          mouseEvent.consume();
          System.out.println(mouseEvent.getX() + " " + mouseEvent.getY());
        });
    rootBorderPane.setOnMouseReleased(mouseEvent -> stopUse(mouseEvent.getX(), mouseEvent.getY()));
  }

  //  private void initialMouseClick(Double x, Double y) {
  //    Mshape s = selectedTool.initialMouseClick(x, y);
  //  }

  private void stopUse(Double x, Double y) {
    System.out.println(x + " " + y);
    Mshape s = selectedTool.stopUse(x, y);
    backend.addToRender(s);
  }
}
