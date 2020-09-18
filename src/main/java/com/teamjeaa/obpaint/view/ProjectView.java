package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.model.FileManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;


public class ProjectView {
	public FileManager fileChooser = new FileManager();

	@FXML
	private Canvas canvas;
	@FXML
	private TextField brushSize;
	@FXML
	ColorPicker colorPicker;
	@FXML
	CheckBox eraser;
	@FXML
	MenuItem fileChoser;


	public void initialize() {
		GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
		brushSize.setText("12");

		canvas.setOnMouseDragged(e -> {
			double size = Double.parseDouble(brushSize.getText());
			double x = e.getX() - size / 2;
			double y = e.getY() - size / 2;
			if ( eraser.isSelected()) {
				graphicsContext.clearRect(x,y,size,size);
			}else {
				graphicsContext.setFill(colorPicker.getValue());
				graphicsContext.fillRect(x,y,size,size);
			}
		});
	}

	@FXML
	private void onFileChoser () {
		fileChooser.loaderFile();
	}

	@FXML
	public void onClose () {
		Platform.exit();
	}


}
