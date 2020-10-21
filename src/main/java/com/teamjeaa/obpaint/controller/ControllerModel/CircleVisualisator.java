package com.teamjeaa.obpaint.controller.ControllerModel;

import com.teamjeaa.obpaint.controller.CanvasController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleVisualisator implements ToolVisualisator {
    private final CanvasController canvasController;
    private Circle circle;
    private int initialX;
    private int initialY;

    public CircleVisualisator(CanvasController canvasController) {
        this.canvasController = canvasController;
    }

    @Override
    public void initiateVisualisation(int x, int y) {
        initialX = x;
        initialY = y;
        circle = new Circle();
        circle.setFill(new Color(0.3,0.3,0.3,0.2));
        canvasController.setGhost(circle);
    }

    @Override
    public void updateVisualisation(int x, int y) {
        double deltaX = (x-initialX);
        double deltaY = (y-initialY);
        double dia = Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2));
        double centerX = (initialX + x)/2.0;;
        double centerY = (initialY + y)/2.0;

        circle.setRadius(dia/2);
        circle.setCenterX(centerX);
        circle.setCenterY(centerY);
    }

    @Override
    public void endVisualisation() {
        canvasController.clearGhost();
    }
}
