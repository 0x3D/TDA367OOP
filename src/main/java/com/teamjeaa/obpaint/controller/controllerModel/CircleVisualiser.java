package com.teamjeaa.obpaint.controller.controllerModel;

import com.teamjeaa.obpaint.controller.CanvasController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
/**
 * CircleVisualiser is a class thats holds the logic about the visualization
 * when you creating a Circle
 *
 * </p> We only use Javafx shapes to visualize this.
 * Its implemented by ToolVisualiser
 *
 * @author Jonas N
 * @since 0.3-SNAPSHOT
 */
public class CircleVisualiser implements ToolVisualiser {
  private final CanvasController canvasController;
  private Circle circle;
  private int initialX;
  private int initialY;

  /**
   * Constructor for our CircleVisualiser
   * @param canvasController takes in a controller
   *                         needed because of javafx
   */
  public CircleVisualiser(CanvasController canvasController) {
    this.canvasController = canvasController;
  }

  @Override
  public void initiateVisualisation(int x, int y) {
    initialX = x;
    initialY = y;
    circle = new Circle();
    circle.setFill(new Color(0.3, 0.3, 0.3, 0.2));
    canvasController.setGhost(circle);
  }

  @Override
  public void updateVisualisation(int x, int y) {
    double deltaX = x - initialX;
    double deltaY = y - initialY;
    double dia = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    double centerX = (initialX + x) / 2.0;
    double centerY = (initialY + y) / 2.0;

    circle.setRadius(dia / 2);
    circle.setCenterX(centerX);
    circle.setCenterY(centerY);
  }

  @Override
  public void endVisualisation() {
    canvasController.clearGhost();
  }
}
