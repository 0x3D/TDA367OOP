package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.controller.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class CanvasView extends BorderPane {

    public CanvasView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/canvasView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(ViewController.getInstance().getCanvasController());

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}
