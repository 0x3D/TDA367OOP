package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.view.DrawVisistor;

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