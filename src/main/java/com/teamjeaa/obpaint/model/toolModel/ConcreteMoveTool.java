package com.teamjeaa.obpaint.model.toolModel;

import com.teamjeaa.obpaint.model.shapeModel.Mshape;

/**
 * Class that holds the logic when we move all of our tools, Used by ConcreteToolFactory, uses
 * MShape and Tool
 *
 * @author Jonas N
 */
public class ConcreteMoveTool implements Tool {
  /**
   * Start use method is used for our mouseMethods
   *
   * @param x1 will be used by save the start Mouse x pos
   * @param y1 will be used by save the start Mouse y pos
   */
  @Override
  public void startUse(Double x1, Double y1) {}

  /**
   * Stop use method is used for our mouseMethods
   *
   * @param x1 save the end mouse x pos
   * @param y1 save the end mouse y pos
   * @return null for now
   */
  @Override
  public Mshape stopUse(Double x1, Double y1) {
    return null;
  }

  /**
   * Used for get the mousepressed
   *
   * @param x position
   * @param y position
   * @return null for now
   */
  @Override
  public Mshape initialMouseClick(double x, double y) {
    return null;
  }
}
