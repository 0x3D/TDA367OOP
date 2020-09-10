package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.model.Project;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;


public class ProjectView {
	@FXML
	private Canvas canvas;
	@FXML
	private TextField brushSize;
	@FXML
	ColorPicker colorPicker;


	public void initialize() {
		GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

		canvas.setOnMouseDragged(e -> {


			double size = Double.parseDouble(brushSize.getText());
			double x = e.getX() - size / 2;
			double y = e.getY() - size / 2;


				graphicsContext.setFill(colorPicker.getValue());
				graphicsContext.fillRect(x,y,size,size);

		});
	}


}
