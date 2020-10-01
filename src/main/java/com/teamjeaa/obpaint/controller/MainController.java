package com.teamjeaa.obpaint.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML AnchorPane mainPane;
    @FXML ToggleButton darkModeToggle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
            mainPane.setStyle("-fx-background-color: rgb(244,244,244)");
        }
    }
}
