package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.controller.MainController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ObjectListItemView extends AnchorPane {

  private final String name;
  private @FXML Label objectLabel;
  private MainController mainController;

  public ObjectListItemView(MainController mainController,String name) {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/objectListItemView.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }
    this.mainController = mainController;
    this.name = name;
    setLabelName();
  }

  public void setLabelName() {
    objectLabel.setText(name);
  }
}
