package com.teamjeaa.obpaint.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainView extends AnchorPane {

  public MainView() {
    FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("/fxml/mainView.fxml")));
    fxmlLoader.setRoot(this);
    //fxmlLoader.setController(MainController.getInstance());

    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }
  }
}
