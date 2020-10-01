package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.view.DrawVisitor;

/**
 * This is the common interface of the shapes in our model *
 *
 * <p>Responsibility Provide Interface shared by all shapes <br>
 * Used by ModelCanvas, JavaFXDrawVisitor, CanvasController, MellipseTest, MpolygonTest <br>
 * Implemented by Mellipse and Mpolygon <br>
 * Uses Mpoint, DrawVisitor
 *
 * @author Erik R
 * @since 0.1-SNAPSHOT
 * @see Mellipse
 * @see Mpolygon
 */
public interface Mshape {
  /** @return Position of the Mshape as a Mpoint */
  Mpoint getPosition();

  /** @return Width of the Mshape */
  int getWidth();

  /** @return Height of the Mshape */
  int getHeight();

  /**
   * Part of the visitor pattern Accept a visitor to the Mshape to be able to draw model
   *
   * @param drawVisitor The visitor that would like to draw
   */
  void acceptDrawVisitor(DrawVisitor drawVisitor);

  /**
   * @param x - int new x pos
   * @param y - int new y pos
   * @return A new Mshape at the given point
   */
  Mshape translate(int x, int y);
}
