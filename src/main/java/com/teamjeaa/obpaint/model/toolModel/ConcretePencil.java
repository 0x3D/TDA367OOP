package com.teamjeaa.obpaint.model.toolModel;

import com.teamjeaa.obpaint.model.shapeModel.Mshape;

/** Class that holds the logic of out pencil */
public class ConcretePencil implements Tool {

  /** Constructor for our pencil */
  public ConcretePencil() {}

  @Override
  public void startUse(Double x1, Double y1) {}

  @Override
  public Mshape stopUse(Double x1, Double y1) {
    return null;
  }

  @Override
  public Mshape initialMouseClick(double x, double y) {
    return null;
  }
}
