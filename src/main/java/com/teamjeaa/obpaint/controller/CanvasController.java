package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.view.DrawVisitor;
import com.teamjeaa.obpaint.view.JavaFXDrawVisitor;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

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

  private Node ghost;
  private ObjectListController objectListController;
  private Model backend;

  /**
   * This method initializes the controller for CanvasView
   *
   * @param location - The location used to resolve relative paths for the root object
   * @param resources - The resources used to localize the root object
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    backend = Model.INSTANCE;
    JavaFXDrawVisitor javaFXDrawVisitor = new JavaFXDrawVisitor(rootBorderPane);
    AnimationTimer animationTimer =
        new AnimationTimer() {
          public void handle(long now) {
            render(javaFXDrawVisitor);
          }
        };
    animationTimer.start();
    fixClipping(rootBorderPane);
  }

  // JavaFX is stupid with Borders of panes, this method adds clipping
  private void fixClipping(Region pane) {
    Rectangle clippingArea = new Rectangle();

    pane.setClip(clippingArea);

    pane.layoutBoundsProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              clippingArea.setWidth(newValue.getWidth());
              clippingArea.setHeight(newValue.getHeight());
            });
  }

  public BorderPane getCanvasPane() {
    return rootBorderPane;
  }

  private void render(DrawVisitor drawVisitor) {
    rootBorderPane.getChildren().clear();
    objectListController.updateList();
    for (Mshape s : backend.getCanvasShapes()) {
      // It wants the old one to be removed if already is a child.
      s.acceptDrawVisitor(drawVisitor);
    }
    if (ghost != null) {
      rootBorderPane.getChildren().add(ghost);
    }
  }

  public void setGhost(Node ghost) {
    this.ghost = ghost;
  }

  public void setObjectListController(ObjectListController objectListController) {
    this.objectListController = objectListController;
  }

  public void clearGhost() {
    this.ghost = null;
  }
}
