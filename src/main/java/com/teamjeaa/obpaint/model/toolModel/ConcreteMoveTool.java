package com.teamjeaa.obpaint.model.toolModel;

import com.teamjeaa.obpaint.model.shapeModel.Mshape;

/** Class that holds the logic when we move all of our tools */
public class ConcreteMoveTool implements Tool {

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

  // TODO Getter för denna är konstigt
  /**
   * getter of our mover
   *
   * @return
   */
  // TODO is this really fitting for public interface?
  public int getSize() {
    return 0;
  }
}
