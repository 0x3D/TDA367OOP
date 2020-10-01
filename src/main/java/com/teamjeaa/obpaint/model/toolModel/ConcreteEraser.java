package com.teamjeaa.obpaint.model.toolModel;

import com.teamjeaa.obpaint.model.shapeModel.Mshape;

/**
 * Eraser class that holds the EraserLogic Uses by ConcreteToolFactory and MShape. Uses Tool
 *
 * @author Axel H
 */
public class ConcreteEraser implements Tool {
  /**
   * Size of the eraser. Final because we want to create a new eraser everytime we change the size
   */
  private final int size;

  /**
   * Constructor for our eraser
   *
   * @param size of the eraser
   */
  public ConcreteEraser(int size) {
    this.size = size;
  }

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

  /**
   * getter for the size of the eraser
   *
   * @return size of the eraser
   */
  // TODO is this really fitting for public interface?
  public int getSize() {
    return size;
  }
}
