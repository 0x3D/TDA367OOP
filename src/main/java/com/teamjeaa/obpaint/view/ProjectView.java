package com.teamjeaa.obpaint.view;

import com.sun.glass.events.MouseEvent;
import com.teamjeaa.obpaint.model.FileManager;
import com.teamjeaa.obpaint.model.shapeModel.ShapeUtil;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Shape;


public class ProjectView {
	@FXML private BorderPane rootBorderPane;
	public FileManager fileChooser = new FileManager();

	@FXML
	ColorPicker colorPicker;
	@FXML
	CheckBox eraser;
	@FXML
	MenuItem fileChoser;



	@FXML
	private void onFileChoser () {
		fileChooser.loaderFile();
	}

	@FXML
	public void onClose () {
		Platform.exit();

	}


	public  BorderPane getRootBorderPane() {
		return rootBorderPane;
	}
}
