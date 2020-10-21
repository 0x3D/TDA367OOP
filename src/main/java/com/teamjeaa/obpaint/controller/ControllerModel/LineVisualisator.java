package com.teamjeaa.obpaint.controller.ControllerModel;

import com.teamjeaa.obpaint.controller.CanvasController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LineVisualisator implements ToolVisualisator{
    private final CanvasController canvasController;
    private Line line;
    private int initialX;
    private int initialY;


    public LineVisualisator(CanvasController canvasController) {
        this.canvasController = canvasController;
    }

    @Override
    public void initiateVisualisation(int x, int y) {
        initialX = x;
        initialY = y;
        line = new Line();
        line.setStartX(initialX);
        line.setStartY(initialY);
        line.setEndX(initialX);
        line.setEndY(initialY);
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
