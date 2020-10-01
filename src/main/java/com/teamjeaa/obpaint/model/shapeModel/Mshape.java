package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.view.DrawVisistor;

/**
 * This is the common interface of the shapes in our model
 *
 * @see Mellipse
 * @see Mpolygon
 */
public interface Mshape {
  Mpoint getPosition();

  int getWidth();

  int getHeight();

  void acceptDrawVisitor(DrawVisistor drawVisistor);

  /**
   * @param x - int new x pos
   * @param y - int new y pos
   * @return New translated Mshape
   */
  Mshape translate(int x, int y);
}
