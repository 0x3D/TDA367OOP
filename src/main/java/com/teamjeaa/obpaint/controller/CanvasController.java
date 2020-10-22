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
  private @FXML
  BorderPane rootBorderPane;

  private Node ghost;
  private ObjectListController objectListController;
  private Model backend;

  /**
   * This method initializes the controller for CanvasView
   *
   * @param location  - The location used to resolve relative paths for the root object
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

  /**
   * fixClipping method makes that you cant paint outside the "borderPane" /"region"
   *
   * @param pane is the regian we limits
   */
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

  /**
   * getter for our canvasPane that is a BorderPane
   *
   * @return rootBorderPane
   */
  public BorderPane getCanvasPane() {
    return rootBorderPane;
  }

  /**
   * The render method is the  one thats render all our visualisations on the rootBorderPane
   *
   * @param drawVisitor translates our own shapes to javaFx visualisations
   */
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

  /**
   * setter gor ghost
   *
   * @param ghost is the object that visualise our "forms" before they adds on the rootBorderPane
   */
  public void setGhost(Node ghost) {
    this.ghost = ghost;
  }

  /**
   * setObjectListController is the method that sets the objectlistcontroller
   * here in the canvasPane.
   * Needed because of JavaFx controller need to be specified in all diffrent FXML files
   *
   * @param objectListController is the controller
   */
  public void setObjectListController(ObjectListController objectListController) {
    this.objectListController = objectListController;
  }

  /**
   * Cleares the ghost from the visualisation
   */
  public void clearGhost() {
    this.ghost = null;
  }
}
