package com.teamjeaa.obpaint.controller.ControllerModel;


import com.teamjeaa.obpaint.controller.CanvasController;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;


public class RectangleVisualisator implements ToolVisualisator {
    private final CanvasController controller;
    private Rectangle rectangle;

    private Shape s;

    private int initialX;
    private int initialY;

    public RectangleVisualisator(CanvasController controller) {
        this.controller = controller;
    }

    @Override
    public void initiateVisualisation(int x, int y) {
        initialX = x;
        initialY = y;
        rectangle = new Rectangle();
        rectangle.setFill(new Color(0.3,0.3,0.3,0.1));
        rectangle.setX(x);
        rectangle.setY(y);
        //canvas.getChildren().add(rectangle);
        controller.setGhost(rectangle);
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
        controller.clearGhost();
    }
}
