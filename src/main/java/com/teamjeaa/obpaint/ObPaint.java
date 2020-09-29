package com.teamjeaa.obpaint;

import com.teamjeaa.obpaint.model.ModelCanvas;
import com.teamjeaa.obpaint.model.Observer;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;
import com.teamjeaa.obpaint.model.toolModel.ConcreteToolFactory;
import com.teamjeaa.obpaint.model.toolModel.Tool;
import com.teamjeaa.obpaint.model.toolModel.ToolFactory;
import com.teamjeaa.obpaint.model.toolModel.ConcreteRectangleTool;
import com.teamjeaa.obpaint.view.JavaFXDrawVisitor;
import com.teamjeaa.obpaint.view.MainView;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public final class ObPaint extends Application {
  // Maybe not the static here
  public static Stage primaryStage;
  private final ToolFactory toolFactory = new ConcreteToolFactory();
  private Tool selectedTool;
  private ModelCanvas modelCanvas;
  private BorderPane rootBorderPane;
  private JavaFXDrawVisitor javaFXDrawVisitor;

  private List<Observer> observers;

  private static ObPaint instance;

  public static void main(String[] args) {
    launch(args);
  }

  /**
   * This method starts up JavaFX and initializes the Model, also sets up renderer
   *
   * @param primaryStage
   * @throws Exception
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    instance = this;
    observers = new ArrayList<Observer>();

    setSelectedTool(new ConcreteRectangleTool());
    setupModel();
    Parent root = setupScene(primaryStage);
    //rootBorderPane = projectView.getRootBorderPane();
    javaFXDrawVisitor = new JavaFXDrawVisitor(rootBorderPane);

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
    AnimationTimer animationTimer =
            new AnimationTimer() {
              public void handle(long now) {
                render();
              }
            };
    animationTimer.start();
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

  private void render() {

    // GraphicsContext fgcx = foreground.getGraphicsContext2D();
    // fgcx.clearRect(0,0,600,600);
    for (Mshape s : modelCanvas.getShapes()) {
      // It wants the old one to be removed if already is a child.
      s.acceptDrawVisitor(javaFXDrawVisitor);
    }
  }

  // Testing on the borderPane!!! | We shouldn't add methods to do tests /eric

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
}
