package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.controller.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainView extends AnchorPane {

  public MainView() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/obPaint.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(ViewController.getInstance());

    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }
  }
}
