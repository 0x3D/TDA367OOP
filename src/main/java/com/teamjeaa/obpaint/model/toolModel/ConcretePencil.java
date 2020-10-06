package com.teamjeaa.obpaint.model.toolModel;

import com.teamjeaa.obpaint.model.shapeModel.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class that holds the logic of out pencil, Used by ConcreteToolFactory and MShape, Uses Tool
 *
 * @author Axel H
 */
public class ConcretePencil implements Tool {
  private double x;
  private double y;

  /** Constructor for our pencil */
  public ConcretePencil() {}

  /**
   * Start use method is used for our mouseMethods
   *
   * @param x1 will be used by save the start Mouse x pos
   * @param y1 will be used by save the start Mouse y pos
   */
  @Override
  public void startUse(Double x1, Double y1) {
    x = x1;
    y = y1;
  }

  /**
   * Stop use method is used for our mouseMethods
   *
   * @param x2 save the end mouse x pos
   * @param y2 save the end mouse y pos
   * @return null for now
   */
  @Override
  public Mshape stopUse(Double x2, Double y2) {
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
   return shapeFactory.createLine((int)x,(int)y,x2.intValue(),y2.intValue(), Color.BLACK);
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
    return null;
  }
}
