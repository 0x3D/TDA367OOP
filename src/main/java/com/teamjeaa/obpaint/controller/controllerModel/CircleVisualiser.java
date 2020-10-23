package com.teamjeaa.obpaint.controller.controllerModel;

import com.teamjeaa.obpaint.controller.CanvasController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
/**
 * CircleVisualiser is a class that holds the logic about the visualization when you creating a
 * Circle We only use Javafx shapes to visualize this. Its implemented by ToolVisualiser
 *
 * @author Jonas N
 * @since 0.3-SNAPSHOT
 */
public final class CircleVisualiser implements ToolVisualiser {
  private final CanvasController canvasController;
  private Circle circle;
  private int initialX;
  private int initialY;

  /**
   * Constructor for our CircleVisualiser
   *
   * @param canvasController takes in a controller needed because of javafx
   */
  public CircleVisualiser(final CanvasController canvasController) {
    this.canvasController = canvasController;
  }

  @Override
  public void initiateVisualisation(final int x, final int y) {
    initialX = x;
    initialY = y;
    circle = new Circle();
    circle.setFill(new Color(0.3, 0.3, 0.3, 0.2));
    canvasController.setGhost(circle);
  }

  @Override
  public void updateVisualisation(final int x, final int y) {
    final double deltaX = x - initialX;
    final double deltaY = y - initialY;
    final double dia = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    final double centerX = (initialX + x) / 2.0;
    final double centerY = (initialY + y) / 2.0;

    circle.setRadius(dia / 2);
    circle.setCenterX(centerX);
    circle.setCenterY(centerY);
  }

  @Override
  public void endVisualisation() {
    canvasController.clearGhost();
  }
}
