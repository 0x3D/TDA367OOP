package com.teamjeaa.obpaint.controller.ControllerModel;

import com.teamjeaa.obpaint.controller.CanvasController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleVisualisator implements ToolVisualisator {
    private final CanvasController canvasController;
    private Rectangle rectangle;
    private int initialX;
    private int initialY;

    public RectangleVisualisator(CanvasController canvasController) {
        this.canvasController = canvasController;
    }

    @Override
    public void initiateVisualisation(int x, int y) {
        initialX = x;
        initialY = y;
        rectangle = new Rectangle();
        rectangle.setFill(new Color(0.3,0.3,0.3,0.2));
        rectangle.setX(x);
        rectangle.setY(y);
        canvasController.setGhost(rectangle);
    }

    @Override
    public void updateVisualisation(int x, int y) {
        double deltaX = (x-initialX);
        double deltaY = (y-initialY);

        rectangle.setWidth(Math.abs(deltaX));
        rectangle.setHeight(Math.abs(deltaY));

        if (deltaX > 0) {
            rectangle.setX(initialX);
        } else {
            rectangle.setX(initialX+deltaX);
        }

        if (deltaY > 0) {
            rectangle.setY(initialY);
        } else {
            rectangle.setY(initialY+deltaY);
        }
    }

    @Override
    public void endVisualisation() {
        canvasController.clearGhost();
    }
}