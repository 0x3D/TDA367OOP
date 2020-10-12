package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.commands.AddEraser;
import com.teamjeaa.obpaint.model.commands.Command;
import com.teamjeaa.obpaint.model.toolModel.ConcreteCircleTool;
import com.teamjeaa.obpaint.model.toolModel.ConcreteEraser;
import com.teamjeaa.obpaint.model.toolModel.ConcretePencil;
import com.teamjeaa.obpaint.model.toolModel.ConcreteRectangleTool;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.net.URL;
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
    private CanvasController canvasController;
  private final Model backend = Model.INSTANCE;
  @FXML private ColorPicker cp;
  @FXML private ToggleButton pencilButton;
  @FXML private ToggleButton brushButton;
  @FXML private ToggleButton eraserButton;
  @FXML private ToggleButton circleButton;
  @FXML private ToggleButton rectangleButton;
  private BorderPane canvasPane;
  private  Command command;

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

    cp.valueProperty()
        .addListener(
            (ObservableValue<? extends Color> observable, Color oldValue, Color newValue) -> {
              java.awt.Color awtColor =
                  new java.awt.Color(
                      (float) newValue.getRed(),
                      (float) newValue.getGreen(),
                      (float) newValue.getBlue(),
                      (float) newValue.getOpacity());

              backend.setSelectedColor(awtColor);
            });
  }

  public void setCanvasController (CanvasController canvasController) {
      this.canvasController = canvasController;
      this.canvasPane = canvasController.getCanvasPane();
  }
  @FXML
   void onPencilButton(ActionEvent event) {
    System.out.println("Pencil");
    backend.setSelectedTool(new ConcretePencil());
  }

  @FXML
   void onEraserButton(ActionEvent  event) {
    System.out.println("Eraser");
    canvasPane.setOnMouseClicked(mouseEvent -> {
        command = new AddEraser((int)mouseEvent.getX(), (int)mouseEvent.getY());
    });
  }

  @FXML
   void onCircleButton(ActionEvent event) {
    backend.setSelectedTool(new ConcreteCircleTool());
  }

  @FXML
   void onRectangleButton(ActionEvent event) {
    backend.setSelectedTool(new ConcreteRectangleTool());
  }


}
