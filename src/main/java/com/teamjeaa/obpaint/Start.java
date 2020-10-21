package com.teamjeaa.obpaint;

import com.teamjeaa.obpaint.server.ObPaintServer;
import com.teamjeaa.obpaint.view.MainView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ResourceBundle;

/**
 * This class is used to start the application
 *
 * @author Jonas N
 * @since 0.1 SNAPSHOT
 */
public final class Start extends Application {
  private static final String XML_MAIN_VIEW = "/fxml/mainView.fxml";
  public static final int SCENE_WIDTH = 900;
  public static final int SCENE_HEIGHT = 680;

  /**
   * Main method of the program
   *
   * @param args - args
   */
  public static void main(final String[] args) {
    final Runnable server = new ObPaintServer();
    final Thread thread = new Thread(server);
    thread.start();
    launch(args);
  }

  /**
   * This method starts up JavaFX and initializes the Model
   *
   * @param primaryStage - The root view of the project
   */
  @Override
  public void start(Stage primaryStage) {
    setupScene(primaryStage);
  }

  private void setupScene(Stage primaryStage) {
    Parent root = new MainView(XML_MAIN_VIEW);

    primaryStage.setOnCloseRequest(
        e -> {
          try {
            stop();
          } catch (Exception exception) {
            exception.printStackTrace();
          }
          Platform.exit();
          System.exit(0);
        });

    ResourceBundle obPaintResourceBundle = ResourceBundle.getBundle("obPaint");
    primaryStage.setTitle(obPaintResourceBundle.getString("application.name"));
    primaryStage.getIcons().add(new Image(obPaintResourceBundle.getString("application.logo.path")));
    primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
    primaryStage.setMinHeight(SCENE_HEIGHT);
    primaryStage.setMinWidth(SCENE_WIDTH);
    primaryStage.show();
  }
}
