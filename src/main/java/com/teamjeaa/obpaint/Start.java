package com.teamjeaa.obpaint;

import com.teamjeaa.obpaint.server.ObPaintServer;
import com.teamjeaa.obpaint.view.MainView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * This class is used to start the application
 *
 * @author Jonas N
 * @since 0.1 SNAPSHOT
 */
public final class Start extends Application {
  private static final String CONFIGURATION_HEADER = "obPaints configuration";
  private static final String XML_MAIN_VIEW = "/fxml/mainView.fxml";
  private static final int SCENE_WIDTH = 900;
  private static final int SCENE_HEIGHT = 680;
  private static final String CFG_PROPERTIES = "cfg.properties";
  private static final String PORT = "port";
  private static final String DEFAULT_PORT_VALUE = "1337";
  private static final String LANGUAGE = "Language";
  private static final String ENGLISH_LANGUAGE = "en";

  /**
   * Main method of the program
   *
   * @param args - args
   */
  public static void main(final String[] args) {
    try {
      makeConfig();
    } catch (final IOException e) {
      // cant do anything about IO exception
      e.printStackTrace();
    }
    final Runnable server = new ObPaintServer(getPort());
    final Thread thread = new Thread(server);
    thread.start();
    launch(args);
  }

  private static void makeConfig() throws IOException {
    final File configFile = new File(CFG_PROPERTIES);
    try {
      final FileReader fileReader = new FileReader(configFile);
      final Properties properties = new Properties();
      properties.load(fileReader);

      final String port = properties.getProperty(PORT);
    } catch (final FileNotFoundException fileNotFoundException) {
      final FileWriter fileWriter = new FileWriter(CFG_PROPERTIES);
      final Properties properties = new Properties();
      properties.setProperty(PORT, DEFAULT_PORT_VALUE);

      properties.setProperty(LANGUAGE, ENGLISH_LANGUAGE);
      properties.store(fileWriter, CONFIGURATION_HEADER);
      fileWriter.close();
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  private static String getPort() {
    final File configFile = new File(CFG_PROPERTIES);
    try {
      final FileReader fileReader = new FileReader(configFile);
      final Properties properties = new Properties();
      properties.load(fileReader);
      return properties.getProperty(PORT);
    } catch (final FileNotFoundException fileNotFoundException) {
      return DEFAULT_PORT_VALUE;
    } catch (final IOException ioException) {
      ioException.printStackTrace();
    }
    return DEFAULT_PORT_VALUE;
  }

  /**
   * This method starts up JavaFX and initializes the Model
   *
   * @param primaryStage - The root view of the project
   */
  @Override
  public void start(final Stage primaryStage) {
    setupScene(primaryStage);
  }

  private void setupScene(final Stage primaryStage) {
    final Parent root = new MainView(XML_MAIN_VIEW);

    primaryStage.setOnCloseRequest(
        e -> {
          try {
            stop();
          } catch (final Exception exception) {
            exception.printStackTrace();
          }
          Platform.exit();
          System.exit(0);
        });

    final ResourceBundle obPaintResourceBundle = ResourceBundle.getBundle("obPaint");
    primaryStage.setTitle(obPaintResourceBundle.getString("application.name"));
    primaryStage
        .getIcons()
        .add(new Image(obPaintResourceBundle.getString("application.logo.path")));
    primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
    primaryStage.setMinHeight(SCENE_HEIGHT);
    primaryStage.setMinWidth(SCENE_WIDTH);
    primaryStage.show();
  }
}
