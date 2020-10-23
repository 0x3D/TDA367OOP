package com.teamjeaa.obpaint.controller.controllerModel;

import com.teamjeaa.obpaint.controller.CanvasController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

/**
 * PencilVisualiser is a class that holds the logic about the visualization when you creating a
 * free line We only use Javafx shapes to visualize this. Its implemented by ToolVisualiser
 *
 * @author Jonas N
 * @since 0.3-SNAPSHOT
 */
public final class PencilVisualiser implements ToolVisualiser {

  private final CanvasController canvasController;

  private Polyline polyline;

  public PencilVisualiser(final CanvasController canvasController) {
    this.canvasController = canvasController;
  }

  @Override
  public void initiateVisualisation(final int x, final int y) {
    polyline = new Polyline();
    polyline.getPoints().addAll((double) x, (double) y);
    polyline.setStrokeWidth(5);
    polyline.setStroke(new Color(0.3, 0.3, 0.3, 0.3));
    canvasController.setGhost(polyline);
  }

  @Override
  public void updateVisualisation(final int x, final int y) {
    polyline.getPoints().addAll((double) x, (double) y);
  }

  @Override
  public void endVisualisation() {
    canvasController.clearGhost();
  }
}
