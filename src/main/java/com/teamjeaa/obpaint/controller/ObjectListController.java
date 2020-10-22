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
  private ShapeInfoController shapeInfoController;

  /**
   * setShapeInfoController sets the shapeInfoController to this class so this method can update the shapeinfo-box
   * Its needed becuase we have a "singeview" javafx application that only can have one controller at the same time.
   * We do this so we can separate theresponsibility to our source code
   *
   * @param shapeInfoController is a shapeInfoController
   */
  public void setShapeInfoController(ShapeInfoController shapeInfoController) {
    this.shapeInfoController = shapeInfoController;
  }

  /**
   * updateList is a method that updates the list on the ObjectListView. If a shape is added to the rootBorderPane,
   * then its updated in the ObjectlistView
   */
  @FXML
  public void updateList() {
    objectFlowPane.getChildren().clear();
    synchronized ("Server") {
      for (Mshape mshapes : Model.INSTANCE.getCanvasShapes()) {
        objectFlowPane.getChildren().add(new ObjectListItemView(mshapes, shapeInfoController));
      }
    }
  }
}
