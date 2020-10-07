package com.teamjeaa.obpaint.model.toolModel;

import com.teamjeaa.obpaint.model.shapeModel.Mshape;
// import javafx.scene.shape.Polyline;

/**
 * Our BrushTool that takes care of the logic of our brush Used by ConcreteToolFactory to create the
 * Brush Uses Mshape
 *
 * @author Axel H
 */
public final class ConcreteBrush implements Tool {

  /** Constructor for our brush */
  public ConcreteBrush() {}

  /**
   * Start use method is used for our mouseMethods
   *
   * @param x1 will be used by save the start Mouse x pos
   * @param y1 will be used by save the start Mouse y pos
   */
  @Override
  public void startUse(Double x1, Double y1) {
    // stroke.getPoints().addAll(x1, y1);
  }

  /**
   * Stop use method is used for our mouseMethods
   *
   * @param x1 save the end mouse x pos
   * @param y1 save the end mouse y pos
   * @return null for now
   */
  @Override
  public Mshape stopUse(Double x1, Double y1) {
    // stroke.getPoints().addAll(x1, y1);
    // Polyline strokeCopy = stroke;
    // stroke = new Polyline();
    // return strokeCopy;
    return null;
  }

  /**
   * Used for get the mouse pressed
   *
   * @param x position
   * @param y position
   * @return null for now
   */
  @Override
  public Mshape initialMouseClick(double x, double y) {
    // return stroke;
    return null;
  }
}
