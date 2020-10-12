package com.teamjeaa.obpaint.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ObjectListItemView extends AnchorPane {

  private final String name;
  private @FXML Label objectLabel;

  public ObjectListItemView(String name) {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/objectListItemView.fxml"));

    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }
    this.name = name;
    setLabelName();
  }

  public void setLabelName() {
    objectLabel.setText(name);
  }
}
