package com.teamjeaa.obpaint.controller.controllerModel;

import com.teamjeaa.obpaint.controller.CanvasController;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 * CircleVisualiser is a class thats holds the logic about the visualization
 * when you creating a Rectangle
 *
 * </p> We only use Javafx shapes to visualize this.
 * Its implemented by ToolVisualiser
 *
 * @author Jonas N
 * @since 0.3-SNAPSHOT
 */
public class RectangleVisualiser implements ToolVisualiser {
    private final CanvasController canvasController;
    private Rectangle rectangle;
    private int initialX;
    private int initialY;

    public RectangleVisualiser(CanvasController canvasController) {
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
        double deltaX = x-initialX;
        double deltaY = y-initialY;

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
