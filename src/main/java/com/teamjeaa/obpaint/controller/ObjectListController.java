package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.view.ObjectListItemView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ObjectListController implements Initializable {
  private MainController parentController;

  public @FXML FlowPane objectFlowPane;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }

  @FXML
  public void updateList() {
    objectFlowPane.getChildren().clear();
    for (Mshape mshapes : Model.INSTANCE.getCanvasShapes()) {
      System.out.println(mshapes.getClass().getName());
      objectFlowPane.getChildren().add(new ObjectListItemView(parentController,"Hej"));
    }
  }
}
