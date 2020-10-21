package com.teamjeaa.obpaint.controller.ControllerModel;

import com.teamjeaa.obpaint.controller.CanvasController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

import java.util.ArrayList;
import java.util.List;


public class PencilVisualisator implements ToolVisualisator {

    private final CanvasController canvasController;

    private Polyline polyline;

    private int initialX;

    private int initialY;

    public PencilVisualisator(CanvasController canvasController) {
        this.canvasController = canvasController;
    }

    @Override
    public void initiateVisualisation(int x, int y) {
        polyline = new Polyline();
        initialX = x;
        initialY = y;

        polyline.getPoints().addAll((double) initialX, (double) initialY);
        polyline.setStrokeWidth(2);
        polyline.setStroke(new Color(0.3,0.3,0.3,0.3));
        canvasController.setGhost(polyline);
    }

    @Override
    public void updateVisualisation(int x, int y) {
        polyline.getPoints().addAll((double) x, (double) y);
    }

    @Override
    public void endVisualisation() {
        canvasController.clearGhost();
    }
}
