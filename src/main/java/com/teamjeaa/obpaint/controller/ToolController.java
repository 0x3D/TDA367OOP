package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.commands.*;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * This class provides a controller for the tools
 *
 * <p>This class sets up a group of buttons to tell the model what tool is selected The class
 * implements the interface Initializable and is used by toolView.fxml
 *
 * @author Jonas N
 * @since 0.1-SNAPSHOT
 */
public final class ToolController implements Initializable {
  private final Model backend = Model.INSTANCE;
  List<Mpoint> points = new ArrayList<>();
  private CanvasController canvasController;
  @FXML private ColorPicker cp;
  @FXML private ToggleButton pencilButton;
  @FXML private ToggleButton brushButton;
  @FXML private ToggleButton eraserButton;
  @FXML private ToggleButton circleButton;
  @FXML private ToggleButton rectangleButton;
  @FXML private ToggleButton moveButton;
  @FXML private Slider strokeSizeSlider;
  private BorderPane canvasPane;
  private Command command;
  private int x;
  private int y;

  /**
   * This method initializes the controller for ToolView
   *
   * @param location - The location used to resolve relative paths for the root object
   * @param resources - The resources used to localize the root object
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    ToggleGroup toolButtons = new ToggleGroup();
    pencilButton.setToggleGroup(toolButtons);
    brushButton.setToggleGroup(toolButtons);
    eraserButton.setToggleGroup(toolButtons);
    circleButton.setToggleGroup(toolButtons);
    rectangleButton.setToggleGroup(toolButtons);
    moveButton.setToggleGroup(toolButtons);
  }

  void setCanvasController(CanvasController canvasController) {
    this.canvasController = canvasController;
    this.canvasPane = canvasController.getCanvasPane();
  }

  private void resetCanvasMouseEventHandlers() {
    canvasPane.setOnMouseClicked(null);
    canvasPane.setOnMousePressed(null);
    canvasPane.setOnMouseReleased(null);
    canvasPane.setOnMousePressed(null);
    canvasPane.setOnMouseReleased(null);
    canvasPane.setOnMouseDragged(null);
  }

  @FXML
  void onPencilButton(ActionEvent event) {
    System.out.println("Selected Pencil tool");
    resetCanvasMouseEventHandlers();

    canvasPane.setOnMouseDragged(
        mouseEvent -> points.add(new Mpoint((int) mouseEvent.getX(), (int) mouseEvent.getY())));
    canvasPane.setOnMouseReleased(
        mouseEvent -> {
          points.add(new Mpoint((int) mouseEvent.getX(), (int) mouseEvent.getY()));
          command = new Pencil(points, getAWTColor(cp.getValue()), "Drawn line");
          command.execute();
          points = new ArrayList<>();
        });
  }

  @FXML
  void onLineButton(ActionEvent event) {
    System.out.println("Selected line tool");
    resetCanvasMouseEventHandlers();
    canvasPane.setOnMousePressed(
        mouseEvent -> {
          this.x = (int) mouseEvent.getX();
          this.y = (int) mouseEvent.getY();
        });
    canvasPane.setOnMouseReleased(
        mouseEvent -> {
          this.command =
              new AddLine(
                  x,
                  y,
                  (int) mouseEvent.getX(),
                  (int) mouseEvent.getY(),
                  getAWTColor(cp.getValue()),
                  "Line");
          command.execute();
        });
  }

  @FXML
  void onEraserButton(ActionEvent event) {
    System.out.println("Eraser");
    resetCanvasMouseEventHandlers();
    canvasPane.setOnMouseClicked(
        mouseEvent -> {
          command = new AddEraser((int) mouseEvent.getX(), (int) mouseEvent.getY());
          command.execute();
        });
  }

  @FXML
  private void onCircleButton(ActionEvent event) {
    System.out.println("Selecting Circle");
    resetCanvasMouseEventHandlers();
    canvasPane.setOnMousePressed(
        mouseEvent -> {
          x = (int) mouseEvent.getX();
          y = (int) mouseEvent.getY();
        });
    canvasPane.setOnMouseReleased(
        mouseEvent -> {
          int dia =
              (int)
                  Math.sqrt(
                      Math.pow(x - mouseEvent.getX(), 2) + Math.pow(y - mouseEvent.getY(), 2));
          int centerX = (int) (x + mouseEvent.getX()) / 2;
          int centerY = (int) (y + mouseEvent.getY()) / 2;
          // Math
          command = new AddCircle(dia / 2, centerX, centerY, getAWTColor(cp.getValue()), "Circle");
          command.execute();
        });
  }

  private java.awt.Color getAWTColor(javafx.scene.paint.Color javafxColor) {
    return new java.awt.Color(
        (float) javafxColor.getRed(),
        (float) javafxColor.getGreen(),
        (float) javafxColor.getBlue(),
        (float) javafxColor.getOpacity());
  }

  @FXML
  private void onRectangleButton(ActionEvent event) {
    System.out.println("Selecting Rectangle");
    resetCanvasMouseEventHandlers();
    canvasPane.setOnMousePressed(
        mouseEvent -> {
          x = (int) mouseEvent.getX();
          y = (int) mouseEvent.getY();
        });
    canvasPane.setOnMouseReleased(
        mouseEvent -> {
          command =
              new AddRectangle(
                  x,
                  y,
                  (int) mouseEvent.getX(),
                  (int) mouseEvent.getY(),
                  getAWTColor(cp.getValue()),
            "Rectangle");
          command.execute();
        });
  }

  @FXML
  private void onMoveButton(ActionEvent event) {
    resetCanvasMouseEventHandlers();
    canvasPane.setOnMousePressed(
        mouseEvent -> {
          x = (int) mouseEvent.getX();
          y = (int) mouseEvent.getY();
        });

    canvasPane.setOnMouseReleased(
        mouseEvent -> {
          command = new Move(x, y, (int) mouseEvent.getX(), (int) mouseEvent.getY());
          command.execute();
        });
  }
}
