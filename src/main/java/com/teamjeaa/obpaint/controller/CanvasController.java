package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.ObPaint;
import com.teamjeaa.obpaint.model.Observer;
import com.teamjeaa.obpaint.model.toolModel.Tool;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CanvasController implements Initializable, Observer {
    @FXML
    BorderPane rootBorderPane;
    ObPaint backend;
    Tool selectedTool;

//Körs innan backend skapas....
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backend = ObPaint.getInstance();
        selectedTool = backend.getSelectedTool();
        backend.addObserver(this);
    }

    @Override
    public void selectedToolHasChanged() {
        selectedTool = backend.getSelectedTool();
    }
}
