package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.toolModel.Tool;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public final class Model {
  // Maybe not the static here
  public static Stage primaryStage;
  private static Color color;
  private static Model instance;
  private Tool selectedTool;
  private ModelCanvas modelCanvas;
  private List<Observer> observers;

  private Model() {
    instance = this;
    observers = new ArrayList<>();
    setSelectedColor(Color.RED);
    setupModel();
  }

  public static Model getInstance() {
    if (instance == null) {
      instance = new Model();
    }
    return instance;
  }

  // TODO Clone
  public static Color getSelectedColor() {
    return color;
  }

  public void setSelectedColor(Color color) {
    Model.color = color;
  }

  private void setupModel() {
    modelCanvas = new ModelCanvas();
    // ShapeFactory shapeFactory = new ConcreteShapeFactory();
    // modelCanvas.addToRender(shapeFactory.createCircle(200, 300, 300));
    // modelCanvas.addToRender(shapeFactory.createRectangle(0,0,300,300));
  }

  public void addToRender(Mshape s) {
    modelCanvas.addToRender(s);
  }

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

  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  public List<Mshape> getCanvasShapes() {
    return modelCanvas.getShapes();
  }
}
