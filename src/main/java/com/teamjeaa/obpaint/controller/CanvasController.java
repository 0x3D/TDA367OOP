package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
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
public final class CanvasController implements Initializable {
  private @FXML BorderPane rootBorderPane;
  private MainController parentController;

  private Model backend;
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

  public void setParentController(MainController mainController) {
    parentController = mainController;
  }

  BorderPane getCanvasPane() {
    return rootBorderPane;
  }

  private void render() {
    rootBorderPane.getChildren().clear();

    for (Mshape s : backend.getCanvasShapes()) {
      // It wants the old one to be removed if already is a child.
      s.acceptDrawVisitor(javaFXDrawVisitor);
    }
  }

  private void initMouseActions() {
    //    rootBorderPane.setOnMouseClicked(
    //      mouseEvent -> initialMouseClick(mouseEvent.getX(), mouseEvent.getY()));
    rootBorderPane.setOnMousePressed(
        mouseEvent -> {
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
    // backend.addToRender(s);
  }

  /*region Description
  private void removeObject (Mshape mshape) {
    rootBorderPane.setOnScroll(
            scrollEvent -> {
              backend.removeMshape(mshape,(int)scrollEvent.getDeltaX(),(int)scrollEvent.getDeltaY());
              scrollEvent.consume();
              System.out.println(scrollEvent.getDeltaX() + "   " + scrollEvent.getDeltaY());
            });

  }
  */
}
