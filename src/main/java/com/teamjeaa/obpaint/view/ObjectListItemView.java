package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.controller.MainController;
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
  private final int xPos;
  private final int yPos;
  private final Color color;

  public ObjectListItemView(int xPos, int yPos, Color color) {


    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/objectListItemView.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }
    this.xPos = xPos;
    this.yPos = yPos;
    this.color = color;

    setLabelName();
    setColorBackground();
  }

  public void setLabelName() {
    objectLabel.setText("X=" + xPos + " Y=" + yPos);
  }

  public void setColorBackground() {
    StringBuilder sb = new StringBuilder();
    sb.append("-fx-background-color: rgb(").append(color.getRed()).append(",").append(color.getGreen()).append(",").
            append(color.getBlue()).append(");").append("-fx-border-color: grey");
    itemPane.setStyle(sb.toString() );
  }

}
