package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;
import com.teamjeaa.obpaint.model.toolModel.*;
import javafx.stage.Stage;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public final class Model {
  // Maybe not the static here
  public static Stage primaryStage;
  private Tool selectedTool;
  private static Color color;
  private ModelCanvas modelCanvas;
  private List<Observer> observers;
  private static Model instance;


  private Model() {
    instance = this;
    observers = new ArrayList<>();
    setSelectedColor(Color.RED);
    setupModel();
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

  public static Model getInstance() {
    if (instance == null) {
      instance = new Model();
    }
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
  public static Color getSelectedColor() {
    return color;
  }

  public void setSelectedColor(Color color) {
    Model.color = color;
  }
}
