package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.view.DrawVisistor;

public interface Mshape {
  Mpoint getPosition();
  int getWidth();
  int getHeight();

  void acceptDrawVisitor(DrawVisistor drawVisistor);
}
