package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.Start;
import com.teamjeaa.obpaint.controller.CanvasController;
import com.teamjeaa.obpaint.controller.ToolController;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.toolModel.*;
import javafx.stage.Stage;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Responsibility Offers the most vital parts of the model without exposing. Creates ModelCanvas and
 * holds List with Observers
 * Used by Start, CanvasController , ConcreteCricleTool, ConcreteRectangleTool, ToolController
 * Uses Color, List, Observer, Tool
 * </p>
 * @author Jonas N
 * @see CanvasController
 * @see ConcreteCircleTool
 * @see ConcreteRectangleTool
 * @see Start
 * @see ToolController
 * @see Color
 * @see List
 * @see Observer
 * @see Tool
 * @since 0.1-SNAPSHOT
 */
public final class Model {
  // Maybe not the static here


  public static Stage primaryStage;
  private static Color color;
  private Tool selectedTool;
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
    modelCanvas = new ModelCanvas();
  }

  /**
   * Adds received instence of Mshape to ModelCanvas list for render.
   * @param s some kind of Mshape.
   */
  public void addToRender(Mshape s) {
    modelCanvas.addToRender(s);
  }

  /** @return the selected tool */
  public Tool getSelectedTool() {
    return selectedTool;
  }

  /**
   * This method is used to save a tool when the user selects it. Uses Observer pattern to notify observers.
   * @param selectedTool Sets the chosen tool to selected for user in order to be able to create som kind of shape.
   */
  public void setSelectedTool(Tool selectedTool) {
    this.selectedTool = selectedTool;
    notifyObservers();
  }

  private void notifyObservers() {
    for (Observer o : observers) {
      o.selectedToolHasChanged();
    }
  }

  /**
   * Singleton pattern. If instance of Model is created it gives requesting class reference to object.
   * @return intance of the Model.
   */
  public static Model getInstance() {
    if (instance == null) {
      instance = new Model();
    }
    return instance;
  }

  /**
   * Observer Pattern. Adds a Observer to the list of observer.
   * @param observer The Observer that should be notified in case of change.
   */
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  /**
   * Removes choosen Observer from list of Observers. Vill no longer be notified.
   * @param observer Observer to be removed from list and no longer will be notified in case of change.
   */
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  /**
   * @return Returns the list of Mshapes collected from modelCanvas.
   */
  public List<Mshape> getCanvasShapes() {
    return modelCanvas.getShapes();
  }

  /**
   *
   * @return Returns the JavaAWT Color that is selected from Controller.
   */
  // TODO Clone
  public static Color getSelectedColor() {
    return color;
  }

  /**
   *
   * @param color Java AWT Color
   */
  public void setSelectedColor(Color color) {
    Model.color = color;
  }
}
