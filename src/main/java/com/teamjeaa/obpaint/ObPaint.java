package com.teamjeaa.obpaint;

import com.teamjeaa.obpaint.model.ModelCanvas;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;
import com.teamjeaa.obpaint.model.toolModel.ConcreteToolFactory;
import com.teamjeaa.obpaint.model.toolModel.Tool;
import com.teamjeaa.obpaint.model.toolModel.ToolFactory;
import com.teamjeaa.obpaint.view.JavaFXDrawVisitor;
import com.teamjeaa.obpaint.view.ProjectView;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

// import javafx.scene.shape.Shape;

public final class ObPaint extends Application {
  // Maybe not the static here
  public static Stage primaryStage;
  private final ToolFactory toolFactory = new ConcreteToolFactory();
  private Tool selectedTool;
  private ModelCanvas modelCanvas;
  private BorderPane rootBorderPane;
  private JavaFXDrawVisitor javaFXDrawVisitor;

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
    ProjectView projectView = setupScene(primaryStage);
    setupModel();

    rootBorderPane = projectView.getRootBorderPane();
    javaFXDrawVisitor = new JavaFXDrawVisitor(rootBorderPane);

    setSelectedTool(toolFactory.createBrush(1));
    setupTool();
  }

  private void setupModel() {
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    modelCanvas = new ModelCanvas();
    modelCanvas.addToRender(shapeFactory.createCircle(200, 300, 300));
  }

  private void setupTool() {
    rootBorderPane.setOnMouseClicked(
        mouseEvent -> initialMouseClick(mouseEvent.getX(), mouseEvent.getY()));
    rootBorderPane.setOnMouseDragged(
        mouseEvent -> selectedTool.startUse(mouseEvent.getX(), mouseEvent.getY()));
    rootBorderPane.setOnMouseReleased(mouseEvent -> stopUse(mouseEvent.getX(), mouseEvent.getY()));
  }

  private ProjectView setupScene(Stage primaryStage) {
    ProjectView projectView = new ProjectView();
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("obPaint.fxml"));
    // Do it like this to be able to set which class has display items. Maybe unnecessary coupling
    fxmlLoader.setController(projectView);

    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }

    ResourceBundle obPaintResourceBundle = ResourceBundle.getBundle("obPaint");

    primaryStage.setTitle(obPaintResourceBundle.getString("application.name"));
    primaryStage.getIcons().add(new Image("images/logo.png"));
    primaryStage.setScene(new Scene(fxmlLoader.getRoot(), 900, 675));
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
    return projectView;
  }

  private void initialMouseClick(Double x, Double y) {
    Mshape s = selectedTool.initialMouseClick(x, y);
    modelCanvas.addToRender(s);
  }

  private void stopUse(Double x, Double y) {
    // Shape s=selectedTool.stopUse(x,y);
    // modelCanvas.addToRender(s);
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
  }
}
