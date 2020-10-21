package com.teamjeaa.obpaint.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * View class that loads the fxml file in to a visual Canvas, with all the fxmlFiles included to
 * One. Used by Start.java. Uses Parent.
 *
 * @author Jonas N
 */
public final class MainView extends AnchorPane {
  private static final boolean  SWEDISHSELECTED = true;

  /** Constructor for our view that holds all the logic to load the FXML file */
  public MainView(String fxmlFileName) {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
    fxmlLoader.setRoot(this);
    // fxmlLoader.setController(MainController.getInstance());

    try {
      ResourceBundle resourceBundle;
      if ( SWEDISHSELECTED) {
        resourceBundle = ResourceBundle.getBundle("obPaint_sv");
      }else{
         resourceBundle = ResourceBundle.getBundle("obPaint_en");
      }
      fxmlLoader.setResources(resourceBundle);
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }
  }
}
