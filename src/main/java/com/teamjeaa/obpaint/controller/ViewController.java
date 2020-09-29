package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.view.CanvasView;
import com.teamjeaa.obpaint.view.ToolView;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML AnchorPane toolViewRoot;
    @FXML AnchorPane canvasViewRoot;
    @FXML AnchorPane mainPane;
    @FXML ToggleButton darkModeToggle;

    private final ToolController toolController;
    private final CanvasController canvasController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toolViewRoot.getChildren().clear();
        toolViewRoot.getChildren().add(new ToolView());

        canvasViewRoot.getChildren().clear();
        canvasViewRoot.getChildren().add(new CanvasView());
    }
    private ViewController() {
        this.toolController = new ToolController();
        this.canvasController = new CanvasController();
    }

    private static ViewController instance;
    public static ViewController getInstance() {
        if (instance == null) {
            instance = new ViewController();
        }
        return instance;
    }

    public ToolController getToolController() {
        return toolController;
    }

    public CanvasController getCanvasController() {
        return canvasController;
    }

    @FXML
    public void onClose() {
        Platform.exit();
    }

    @FXML
    public void darkModeOn() {
        if (darkModeToggle.isSelected()) {
            mainPane.setStyle("-fx-background-color: rgb(45,45,45)");
        } else {
            mainPane.setStyle("-fx-background-color: transparent");
        }
    }
}
