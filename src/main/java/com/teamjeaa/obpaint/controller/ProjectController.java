package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.ObPaint;
import com.teamjeaa.obpaint.model.FileManager;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeUtil;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * Controller
 */
public class ProjectController {
    public FileManager fileChooser = new FileManager();
    @FXML
    MenuItem fileChoser;
    /** Lite go testning bara */
    @FXML private BorderPane rootBorderPane;
    @FXML
    private void onFileChoser() {
        fileChooser.loaderFile();
    }
    ObPaint backend = ObPaint.getInstance();
  /*
  public String getColor() {
  	return cp.getValue().toString();
  }



   */
    public BorderPane getRootBorderPane() {
        return rootBorderPane;
    }

    @FXML
    public void placeRectangleShape(MouseEvent event) {

    }
/*
    public void onEraserButton(MouseEvent event) {

    }*/

  /*
  public void getMouseXPos () {
  	rootBorderPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
  		@Override
  		public void handle(MouseEvent mouseEvent) {
  			x1 = mouseEvent.getX();
  		}
  	});
  }
  public void getMouseYPos () {
  	rootBorderPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
  		@Override
  		public void handle(MouseEvent mouseEvent) {
  			y1 = mouseEvent.getY();
  		}
  	});
  }

   */



}
