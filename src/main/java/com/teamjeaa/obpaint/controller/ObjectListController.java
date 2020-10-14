package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.view.ObjectListItemView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ObjectListController implements Initializable {
  public @FXML FlowPane objectFlowPane;
  private MainController parentController;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {}

  @FXML
  public void updateList() {
    objectFlowPane.getChildren().clear();
    for (Mshape mshapes : Model.INSTANCE.getCanvasShapes()) {
      objectFlowPane.getChildren().add(new ObjectListItemView(mshapes, parentController));
    }
  }

  public void setParentController(MainController mainController) {
    this.parentController = mainController;
  }
}
