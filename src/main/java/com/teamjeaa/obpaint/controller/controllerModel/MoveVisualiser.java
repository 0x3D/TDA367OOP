package com.teamjeaa.obpaint.controller.controllerModel;

import com.teamjeaa.obpaint.controller.CanvasController;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * MoveVisualiser is a class that holds the logic about the visualization when you Moving We only
 * use Javafx shapes to visualize this. Its implemented by ToolVisualiser
 *
 * @author Jonas N
 * @since 0.3-SNAPSHOT
 */
public final class MoveVisualiser implements ToolVisualiser {
  private final CanvasController canvasController;

  private final BorderPane canvasPane;

  private int initialX;

  private int initialY;

  private Shape ghost;

  public MoveVisualiser(final CanvasController canvasController) {
    this.canvasController = canvasController;
    this.canvasPane = canvasController.getCanvasPane();
  }

  @Override
  public void initiateVisualisation(final int x, final int y) {
    this.initialX = x;
    this.initialY = y;

    for (final Node n : canvasPane.getChildren()) {
      if (n.contains(x, y)) {
        ghost = (Shape) n;
        ghost.setFill(new Color(0.3, 0.3, 0.3, 0.2));
        ghost.setStroke(new Color(0.3, 0.3, 0.3, 0.2));
      }
    }
    canvasController.setGhost(ghost);
  }

  @Override
  public void updateVisualisation(final int x, final int y) {
    final int deltaX = x - initialX;
    final int deltaY = y - initialY;

    if (ghost != null) {
      ghost.setTranslateY(deltaY);
      ghost.setTranslateX(deltaX);
    }
  }

  @Override
  public void endVisualisation() {
    ghost = null;
    canvasController.clearGhost();
  }
}
