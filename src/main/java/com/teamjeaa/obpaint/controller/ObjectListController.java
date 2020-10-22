package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.view.ObjectListItemView;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;

/**
 * ObjectListController is a controller class for the shapeList
 * Used by mainController
 *
 * @author Axel H
 * @since 0.3-SNAPSHOT
 */
public class ObjectListController {
  private @FXML
  FlowPane objectFlowPane;
  private MainController parentController;

  /**
   * updateList is a method that updates the list on the ObjectListView. If a shape is added to the rootBorderPane,
   * then its updated in the ObjectlistView
   */
  @FXML
  public void updateList() {
    objectFlowPane.getChildren().clear();
    synchronized ("Server") {
      for (Mshape mshapes : Model.INSTANCE.getCanvasShapes()) {
        objectFlowPane.getChildren().add(new ObjectListItemView(mshapes, parentController));
      }
    }
  }

  /**
   * SetParentController sets the maincontroller to this class so this method can be calles in mainController
   * Its needed becuase we have a "singeview" javafx application that only can have one controller at the same time.
   * We do this so we can separate theresponsibility to our  source code
   *
   * @param mainController is a mainController
   */
  public void setParentController(MainController mainController) {
    this.parentController = mainController;
  }
}
