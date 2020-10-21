package com.teamjeaa.obpaint.controller.controllerModel;

import com.teamjeaa.obpaint.controller.CanvasController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;



public class PencilVisualiser implements ToolVisualiser {

    private final CanvasController canvasController;

    private Polyline polyline;

    public PencilVisualiser(CanvasController canvasController) {
        this.canvasController = canvasController;
    }

    @Override
    public void initiateVisualisation(int x, int y) {
        polyline = new Polyline();

        polyline.getPoints().addAll((double) x, (double) y);
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
