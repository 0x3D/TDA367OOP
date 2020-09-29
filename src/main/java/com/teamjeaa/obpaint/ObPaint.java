package com.teamjeaa.obpaint;

import com.teamjeaa.obpaint.model.ModelCanvas;
import com.teamjeaa.obpaint.model.Observer;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;
import com.teamjeaa.obpaint.model.toolModel.*;
import com.teamjeaa.obpaint.view.MainView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public final class ObPaint extends Application {
  // Maybe not the static here
  public static Stage primaryStage;
  private Tool selectedTool;
  private static Color color;
  private ModelCanvas modelCanvas;
  private List<Observer> observers;
  private static ObPaint instance;


  public static void main(String[] args) {
    launch(args);
  }

  /**
   * This method starts up JavaFX and initializes the Model
   *
   * @param primaryStage
   * @throws Exception
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    instance = this;
    observers = new ArrayList<Observer>();

    setSelectedTool(new ConcreteCircleTool());
    setupModel();
    Parent root = setupScene(primaryStage);
  }

  private Parent setupScene(Stage primaryStage) {
    Parent root = new MainView();

    primaryStage.setOnCloseRequest(e->{
      try{stop();}
      catch (Exception exception){exception.printStackTrace();}
      Platform.exit();
      System.exit(0);
    });

    ResourceBundle obPaintResourceBundle = ResourceBundle.getBundle("obPaint");
    primaryStage.setTitle(obPaintResourceBundle.getString("application.name"));
    primaryStage.getIcons().add(new Image("images/logo.png"));
    primaryStage.setScene(new Scene(root, 900, 675));
    primaryStage.setMinHeight(680);
    primaryStage.setMinWidth(900);
    primaryStage.show();
    ObPaint.primaryStage = primaryStage;
    return root;
  }

  private void setupModel() {
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    modelCanvas = new ModelCanvas();
    //modelCanvas.addToRender(shapeFactory.createCircle(200, 300, 300));
    //modelCanvas.addToRender(shapeFactory.createRectangle(0,0,300,300));
  }

  public void addToRender(Mshape s) {
    modelCanvas.addToRender(s);
  }

  /** */
  public void mouseXpos() {}

  /** */
  public void mouseYpos() {}

  // END

  /** @return the selected tool */
  public Tool getSelectedTool() {
    return selectedTool;
  }

  /** @param selectedTool This method is used to save a tool when the user selects it */
  public void setSelectedTool(Tool selectedTool) {
    this.selectedTool = selectedTool;
    notifyObservers();
  }

  private void notifyObservers() {
    for (Observer o : observers) {
      o.selectedToolHasChanged();
    }
  }

  public static ObPaint getInstance() {
    return instance;
  }

  public void addObserver(Observer observer) {
    observers.add(observer);
  }
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }
  public List<Mshape> getCanvasShapes() {
    return modelCanvas.getShapes();
  }

//TODO Clone
  public Color getSelectedColor() {
    return color;
  }

  public void setSelectedColor(Color color) {
    ObPaint.color = color;
  }
}
