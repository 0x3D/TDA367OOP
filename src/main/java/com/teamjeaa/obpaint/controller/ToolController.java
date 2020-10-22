package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.controller.controllerModel.*;
import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.commands.*;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import javafx.scene.layout.Pane;


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
  private static final int JAVAFX_MODEL_COLOR_CONSTANT = 255;
  private final static int START_UP_STROKE_SIZE = 5;
  @FXML private ColorPicker cp;
  @FXML private ToggleButton pencilButton;
  @FXML private ToggleButton brushButton;
  @FXML private ToggleButton eraserButton;
  @FXML private ToggleButton circleButton;
  @FXML private ToggleButton rectangleButton;
  @FXML private ToggleButton moveButton;
  @FXML private TextField widthTextField;

  List<Mpoint> points = new ArrayList<>();
  private CanvasController canvasController;
  private Pane canvasPane;
  private Command command;
  private int x;
  private int y;
  private ToolVisualiser toolVisualiser;

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
    widthTextField.setText(String.valueOf(START_UP_STROKE_SIZE));
  }

  void setCanvasController(CanvasController canvasController) {
    this.canvasController = canvasController;
    this.canvasPane = canvasController.getCanvasPane();
  }

  /**
   * resets all the mouseEventsHandlers
   */
  private void resetCanvasMouseEventHandlers() {
    //unfortunately this is the only way to reset all mouseevent-handlers...
    canvasPane.setOnMouseClicked(null);
    canvasPane.setOnMousePressed(null);
    canvasPane.setOnMouseReleased(null);
    canvasPane.setOnMousePressed(null);
    canvasPane.setOnMouseReleased(null);
    canvasPane.setOnMouseDragged(null);
  }

  /**
   * onPencilButton is the method that is calls when we want to use the pencil
   */
  @FXML
  private void onPencilButton() {
    System.out.println("Selected Pencil tool");
    resetCanvasMouseEventHandlers();
    toolVisualiser = new PencilVisualiser(canvasController);

    canvasPane.setOnMousePressed(
        mouseEvent -> {
          x = (int) mouseEvent.getX();
          y = (int) mouseEvent.getY();
          toolVisualiser.initiateVisualisation(x, y);
        });

    canvasPane.setOnMouseDragged(
        mouseEvent -> {
          points.add(new Mpoint((int) mouseEvent.getX(), (int) mouseEvent.getY()));
          toolVisualiser.updateVisualisation((int) mouseEvent.getX(), (int) mouseEvent.getY());
        });


    canvasPane.setOnMouseReleased(
        mouseEvent -> {
          points.add(new Mpoint((int) mouseEvent.getX(), (int) mouseEvent.getY()));
          command =
              new Pencil(
                  points,
                  convertToModelColor(cp.getValue()),
                  "Drawn line",
                  Integer.parseInt(widthTextField.getText()));
          command.execute();
          points = new ArrayList<>();
          toolVisualiser.endVisualisation();
        });
  }

  /**
   * onLineButton is the method that is calls when we want to use the line
   */
  @FXML
  private void onLineButton(ActionEvent event) {
    System.out.println("Selected line tool");
    resetCanvasMouseEventHandlers();
    toolVisualiser = new LineVisualiser(canvasController);

    canvasPane.setOnMousePressed(
        mouseEvent -> {
          this.x = (int) mouseEvent.getX();
          this.y = (int) mouseEvent.getY();
          toolVisualiser.initiateVisualisation(x, y);
        });

    canvasPane.setOnMouseDragged(
        e -> toolVisualiser.updateVisualisation((int) e.getX(), (int) e.getY()));

    canvasPane.setOnMouseReleased(
        mouseEvent -> {
          this.command =
              new AddLine(
                  x,
                  y,
                  (int) mouseEvent.getX(),
                  (int) mouseEvent.getY(),
                  convertToModelColor(cp.getValue()),
                  "Straight line",
                  Integer.parseInt(widthTextField.getText()));
          command.execute();
          toolVisualiser.endVisualisation();
        });
  }
  /**
   * onEraserButton is the method that is calls when we want to use the eraser
   */
  @FXML
  private void onEraserButton() {
    System.out.println("Eraser");
    resetCanvasMouseEventHandlers();
    canvasPane.setOnMouseClicked(
        mouseEvent -> {
          command = new Eraser((int) mouseEvent.getX(), (int) mouseEvent.getY());
          command.execute();
        });
  }
  /**
   * onCircleButton is the method that is calls when we want to use the circle
   */
  @FXML
  private void onCircleButton() {
    System.out.println("Selecting Circle");
    resetCanvasMouseEventHandlers();
    toolVisualiser = new CircleVisualiser(canvasController);

    canvasPane.setOnMousePressed(
        mouseEvent -> {
          x = (int) mouseEvent.getX();
          y = (int) mouseEvent.getY();
          toolVisualiser.initiateVisualisation(x, y);
        });

    canvasPane.setOnMouseDragged(
        e -> toolVisualiser.updateVisualisation((int) e.getX(), (int) e.getY()));

    canvasPane.setOnMouseReleased(
        mouseEvent -> {
          int dia =
              (int)
                  Math.sqrt(
                      Math.pow(x - mouseEvent.getX(), 2) + Math.pow(y - mouseEvent.getY(), 2));
          int centerX = (int) (x + mouseEvent.getX()) / 2;
          int centerY = (int) (y + mouseEvent.getY()) / 2;
          // Math
          command =
              new AddCircle(
                  dia / 2, centerX, centerY, convertToModelColor(cp.getValue()), "Circle");
          command.execute();
          toolVisualiser.endVisualisation();
        });
  }

  /**
   * onRectangleButton is the method that is calls when we want to use the rectangle
   */
  @FXML
  private void onRectangleButton() {
    System.out.println("Selecting Rectangle");
    resetCanvasMouseEventHandlers();
    toolVisualiser = new RectangleVisualiser(canvasController);

    canvasPane.setOnMousePressed(
        mouseEvent -> {
          x = (int) mouseEvent.getX();
          y = (int) mouseEvent.getY();
          toolVisualiser.initiateVisualisation(x, y);
        });

    canvasPane.setOnMouseDragged(
        e -> toolVisualiser.updateVisualisation((int) e.getX(), (int) e.getY()));

    canvasPane.setOnMouseReleased(
        mouseEvent -> {
          command =
              new AddRectangle(
                  x,
                  y,
                  (int) mouseEvent.getX(),
                  (int) mouseEvent.getY(),
                  convertToModelColor(cp.getValue()),
                  "Rectangle");
          command.execute();
          toolVisualiser.endVisualisation();
        });
  }

  /**
   * onMoveButton is the method that is calls when we want to use the moveCommand
   */
  @FXML
  private void onMoveButton() {
    resetCanvasMouseEventHandlers();
    toolVisualiser = new MoveVisualiser(canvasController);

    canvasPane.setOnMousePressed(
        mouseEvent -> {
          x = (int) mouseEvent.getX();
          y = (int) mouseEvent.getY();
          toolVisualiser.initiateVisualisation(x, y);
        });

    canvasPane.setOnMouseDragged(
        e -> toolVisualiser.updateVisualisation((int) e.getX(), (int) e.getY()));

    canvasPane.setOnMouseReleased(
        mouseEvent -> {
          toolVisualiser.endVisualisation();
          command = new Move(x, y, (int) mouseEvent.getX(), (int) mouseEvent.getY());
          command.execute();
          toolVisualiser.endVisualisation();
        });
  }

  /**
   * Convers our own ColorClass to javaFxColor
   * @param javafxColor is he javaFxColor
   * @return our own Color class
   */
  private Color convertToModelColor(javafx.scene.paint.Color javafxColor) {
    return new Color(
            (int) (javafxColor.getRed() * JAVAFX_MODEL_COLOR_CONSTANT),
            (int) (javafxColor.getGreen() * JAVAFX_MODEL_COLOR_CONSTANT),
            (int) (javafxColor.getBlue() * JAVAFX_MODEL_COLOR_CONSTANT),
            (int) (javafxColor.getOpacity() * JAVAFX_MODEL_COLOR_CONSTANT));
  }
}
