package com.teamjeaa.obpaint.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
/**
 * View class that loads the fxml file in to a visual Canvas, with all the fxmlFiles included to
 * One. Used by Start.java. Uses Parent.
 *
 * @author Jonas N
 */
public final class MainView extends AnchorPane {

  private final String fxmlFileName;
  /** Constructor for our view that holds all the logic to load the FXML file */
  public MainView(String fxmlFileName) {
    this.fxmlFileName = fxmlFileName;
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
    fxmlLoader.setRoot(this);
    // fxmlLoader.setController(MainController.getInstance());

    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }
  }
}
