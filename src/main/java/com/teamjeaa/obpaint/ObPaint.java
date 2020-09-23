package com.teamjeaa.obpaint;

import com.teamjeaa.obpaint.model.ModelCanvas;
import com.teamjeaa.obpaint.model.shapeModel.ShapeUtil;
import com.teamjeaa.obpaint.model.toolModel.ConcreteToolFactory;
import com.teamjeaa.obpaint.model.toolModel.Tool;
import com.teamjeaa.obpaint.model.toolModel.ToolFactory;
import com.teamjeaa.obpaint.view.ProjectView;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public final class ObPaint extends Application {
  //Maybe not the static here
  public static Stage primaryStage;
  private final ToolFactory toolFactory = new ConcreteToolFactory();
  private Tool selectedTool;
  private ModelCanvas modelCanvas;


  private BorderPane rootBorderPane;

  //TODO: Discuss with team


  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    ProjectView projectView = new ProjectView();
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("obPaint.fxml"));
    //Do it like this to be able to set which class has display items. Maybe unnecessary coupling
    fxmlLoader.setController(projectView);

    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }

    ResourceBundle obPaintResourceBundle = ResourceBundle.getBundle("obPaint");

    Canvas foreground = new Canvas(600, 600);



    primaryStage.setTitle(obPaintResourceBundle.getString("application.name"));
    primaryStage.getIcons().add(new Image("images/logo.png"));
    primaryStage.setScene(new Scene(fxmlLoader.getRoot(), 900, 675));
    primaryStage.show();
    ObPaint.primaryStage = primaryStage;


    modelCanvas = new ModelCanvas();

    //Pull based for now :)
    AnimationTimer animationTimer = new AnimationTimer() {
      public void handle(long now) {
        //Random to display movement, Should be replace by actually doing things
        Random r = new Random();
        for(Shape s: modelCanvas.getShapes()){
          s.setTranslateX(50);
          s.setTranslateY(200);
        }
        render();
      }
    };

    Rectangle r = new Rectangle(100,100, Color.BLACK);
    modelCanvas.addToRender(r);

    Shape c = new Circle(10,20,30,Color.WHITE);
    modelCanvas.addToRender(c);
    animationTimer.start();
    rootBorderPane=projectView.getRootBorderPane();
    //rootBorderPane.setCenter(foreground);
  }

  private void render() {
    //GraphicsContext fgcx = foreground.getGraphicsContext2D();
    //fgcx.clearRect(0,0,600,600);
    for(Shape s: modelCanvas.getShapes()){
      //It wants the old one to be removed if already is a child.
      rootBorderPane.getChildren().remove(s);
      rootBorderPane.getChildren().add(s);
    }
  }

  //Testing on the borderPane!!!



  public void mouseXpos (){

  }
  public void mouseYpos (){

  }
  //END


  public Tool getSelectedTool() {
    return selectedTool;
  }

  public void setSelectedTool(Tool selectedTool) {
    this.selectedTool = selectedTool;
  }
}