package com.teamjeaa.obpaint.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * View class that loads the fxml file in to a visual Canvas, with all the fxmlFiles included to
 * One. Used by Start.java. Uses Parent.
 *
 * @author Jonas N
 */
public final class MainView extends AnchorPane {

  private static final String OB_PAINT_EN = "obPaint_en";
  private static final String OB_PAINT_SV = "obPaint_sv";
  private static final String OB_PAINT_SP = "obPaint_sp";
  private static final String CFG_PROPERTIES = "cfg.properties";
  private static final String LANGUAGE = "Language";
  private static final String SWEDISH_LANGUAGE = "sv";
  private static final String SPANISH_LANGUAGE = "sp";

  /** Constructor for our view that holds all the logic to load the FXML file */
  public MainView(final String fxmlFileName) {
    final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
    fxmlLoader.setRoot(this);
    ResourceBundle resourceBundle = ResourceBundle.getBundle(OB_PAINT_EN);
    try {
      final File file = new File(CFG_PROPERTIES);
      final Properties properties = new Properties();
      final FileReader fileReader = new FileReader(file);
      properties.load(fileReader);
      final String language = properties.getProperty(LANGUAGE);
      if (language.equals(SWEDISH_LANGUAGE)) {
        resourceBundle = ResourceBundle.getBundle(OB_PAINT_SV);
      }else if ( language.equals(SPANISH_LANGUAGE)) {
        resourceBundle = ResourceBundle.getBundle(OB_PAINT_SP);
      }
      fxmlLoader.setResources(resourceBundle);
    } catch (final IOException e) {
      e.printStackTrace();
    }
    try {
      fxmlLoader.load();
    } catch (final IOException exception) {
      throw new RuntimeException(exception);
    }
  }
}
