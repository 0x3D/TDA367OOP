package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.ObPaint;
import com.teamjeaa.obpaint.model.Observer;
import com.teamjeaa.obpaint.model.toolModel.ConcreteRectangleTool;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

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
        /*toolButtons.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                newValue.
            }
        });*/

        cp.valueProperty().addListener( (ObservableValue<? extends Color> observable, Color oldValue, Color newValue) -> {
            java.awt.Color awtColor = new java.awt.Color(   (float) newValue.getRed(),
                                                            (float) newValue.getGreen(),
                                                            (float) newValue.getBlue(),
                                                            (float) newValue.getOpacity());
            backend.setSelectedColor(awtColor);
        });

        /*cp.valueProperty().addListener(new ChangeListener<Color>() {
            @Override
            public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
                java.awt.Color awtColor = new java.awt.Color((float) newValue.getRed(), (float) newValue.getGreen(), (float) newValue.getBlue(), (float) newValue.getOpacity()));
                backend.setSelectedColor(awtColor);
            }
        });*/
    }

    @FXML
    void onEraserButton(ActionEvent event) {
        System.out.println("Eraser");
    }

    @FXML
    void onRectangleButton(ActionEvent event) {
        backend.setSelectedTool(new ConcreteRectangleTool());
    }
}
