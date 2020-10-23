package com.teamjeaa.obpaint.controller.controllerModel;

import com.teamjeaa.obpaint.controller.CanvasController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * LineVisualiser is a class that holds the logic about the visualization when you creating a Line
 * We only use Javafx shapes to visualize this. Its implemented by ToolVisualiser
 *
 * @author Jonas N
 * @since 0.3-SNAPSHOT
 */
public final class LineVisualiser implements ToolVisualiser {
  private final CanvasController canvasController;
  private Line line;

  public LineVisualiser(final CanvasController canvasController) {
    this.canvasController = canvasController;
  }

  @Override
  public void initiateVisualisation(final int x, final int y) {
    line = new Line();
    line.setStartX(x);
    line.setStartY(y);
    line.setEndX(x);
    line.setEndY(y);
    line.setStrokeWidth(5);
    line.setStroke(new Color(0.3, 0.3, 0.3, 0.2));
    canvasController.setGhost(line);
  }

  @Override
  public void updateVisualisation(final int x, final int y) {
    line.setEndX(x);
    line.setEndY(y);
  }

  @Override
  public void endVisualisation() {
    canvasController.clearGhost();
  }
}
