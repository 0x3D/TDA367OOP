package com.teamjeaa.obpaint.view;

import com.sun.glass.events.MouseEvent;
import com.teamjeaa.obpaint.model.FileManager;
import com.teamjeaa.obpaint.model.shapeModel.ShapeUtil;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
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
	ToggleButton darkModeToggle;
	@FXML
	AnchorPane mainPain;

	@FXML
	private void onFileChoser () {
		fileChooser.loaderFile();
	}

	@FXML
	public void onClose () {
		Platform.exit();

	}
	@FXML
	public void darkModeOn () {
		if (darkModeToggle.isSelected() ) {
			mainPain.setStyle("-fx-background-color: rgb(45,45,45)");
		}else {
			mainPain.setStyle("-fx-background-color: transparent");
		}

	}

	public  BorderPane getRootBorderPane() {
		return rootBorderPane;
	}
}
