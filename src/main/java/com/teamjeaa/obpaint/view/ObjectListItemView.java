package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.controller.MainController;
import com.teamjeaa.obpaint.controller.ShapeInfoController;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

public class ObjectListItemView extends AnchorPane {

  //private final String name;
  private @FXML
  Label objectLabel;
  private @FXML
  AnchorPane itemPane;

  private final Mshape mshape;
  private final MainController parentController;

  public ObjectListItemView(Mshape mshape, MainController mainController) {


    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/objectListItemView.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }
    this.mshape = mshape;
    this.parentController = mainController;

    setLabelName();
    setColorBackground();
  }

  public void setLabelName() {
    objectLabel.setText("X=" + mshape.getPosition().getX() + " Y=" + mshape.getPosition().getY());
  }

  public void setColorBackground() {
    Color color = mshape.getColor();
    StringBuilder sb = new StringBuilder();
    sb.append("-fx-background-color: rgb(").append(color.getRed()).append(",").append(color.getGreen()).append(",").
            append(color.getBlue()).append(");").append("-fx-border-color: grey");
    itemPane.setStyle(sb.toString());
  }

  public void onClickedListItem () {
    parentController.updateShapeInfo(mshape);
    System.out.println(mshape.getPosition().getX());
  }


}
