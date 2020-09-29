package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.ObPaint;
import com.teamjeaa.obpaint.model.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ToolController implements Initializable {

    ObPaint backend = ObPaint.getInstance();

    @FXML
    private ColorPicker cp;

    @FXML
    private ToggleButton pencilButton;

    @FXML
    private ToggleButton brushButton;

    @FXML
    private ToggleButton eraserButton;

    @FXML
    private ToggleButton circleButton;

    @FXML
    private ToggleButton rectangleButton;

    ToggleGroup toolButtons;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toolButtons = new ToggleGroup();
        pencilButton.setToggleGroup(toolButtons);

        brushButton.setToggleGroup(toolButtons);

        eraserButton.setToggleGroup(toolButtons);

        circleButton.setToggleGroup(toolButtons);

        rectangleButton.setToggleGroup(toolButtons);

    }

    @FXML
    void onEraserButton(ActionEvent event) {
        System.out.println("Eraser");
    }

    @FXML
    void onRectangleButton(ActionEvent event) {
        System.out.println("Rectangle");
    }
}
