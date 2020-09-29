package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.model.FileManager;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

/**
 * Controller
 */
public class ProjectController {
    public FileManager fileChooser = new FileManager();
    @FXML
    MenuItem fileChoser;
    /** Lite go testning bara */
    @FXML
    private void onFileChoser() {
        fileChooser.loaderFile();
    }
  /*
  public String getColor() {
  	return cp.getValue().toString();
  }

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
