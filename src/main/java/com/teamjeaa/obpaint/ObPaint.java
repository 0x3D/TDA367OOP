package com.teamjeaa.obpaint;

import com.teamjeaa.obpaint.model.toolModel.ConcreteToolFactory;
import com.teamjeaa.obpaint.model.toolModel.Tool;
import com.teamjeaa.obpaint.model.toolModel.ToolFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Our application that runs our project
 */
public final class ObPaint extends Application {
  /**
   * Our instances that we use in the Class
   */
  public static Stage primaryStage;
  private final ToolFactory toolFactory = new ConcreteToolFactory();
  private Tool selectedTool;


  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Methods that load the Stage for us to get a Visuel interface
   * @param primaryStage
   * @throws Exception
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root =
            FXMLLoader.load(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("obPaint.fxml")));
    ResourceBundle obPaintResourceBundle = ResourceBundle.getBundle("obPaint");
    primaryStage.setTitle(obPaintResourceBundle.getString("application.name"));
    primaryStage.getIcons().add(new Image("images/logo.png"));
    primaryStage.setScene(new Scene(root, 600, 600));
    primaryStage.show();
    // TODO: Add a drawing area

    ObPaint.primaryStage = primaryStage;
  }

  /**
   * Getter for the selected tool that we use
   * @return the tool
   */
  public Tool getSelectedTool() {
    return selectedTool;
  }

  /**
   * Set the selevted Tool
   * @param selectedTool Is the tool you select
   */
  public void setSelectedTool(Tool selectedTool) {
    this.selectedTool = selectedTool;
  }
}
