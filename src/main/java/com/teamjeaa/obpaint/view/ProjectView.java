package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.model.Project;
import javafx.scene.canvas.Canvas;


public class ProjectView {
	private final Canvas canvas = new Canvas();
	public ProjectView() {

		canvas.setHeight(800); canvas.setWidth(600);
		canvas.setVisible(true);
	}

}
