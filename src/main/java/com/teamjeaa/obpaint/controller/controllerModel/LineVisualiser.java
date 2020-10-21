package com.teamjeaa.obpaint.controller.controllerModel;

import com.teamjeaa.obpaint.controller.CanvasController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LineVisualiser implements ToolVisualiser {
    private final CanvasController canvasController;
    private Line line;


    public LineVisualiser(CanvasController canvasController) {
        this.canvasController = canvasController;
    }

    @Override
    public void initiateVisualisation(int x, int y) {
        line = new Line();
        line.setStartX(x);
        line.setStartY(y);
        line.setEndX(x);
        line.setEndY(y);
        line.setStrokeWidth(2);
        line.setStroke(new Color(0.3,0.3,0.3,0.2));
        canvasController.setGhost(line);
    }

    @Override
    public void updateVisualisation(int x, int y) {
        line.setEndX(x);
        line.setEndY(y);
    }

    @Override
    public void endVisualisation() {
        canvasController.clearGhost();
    }
}
