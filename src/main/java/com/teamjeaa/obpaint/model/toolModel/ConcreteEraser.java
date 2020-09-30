package com.teamjeaa.obpaint.model.toolModel;

import com.teamjeaa.obpaint.model.shapeModel.Mshape;

/** Eraser class that holds the EraserLogic */
public class ConcreteEraser implements Tool {
  /**
   * Size og the eraser. Final because we want to create a new eraser everytime we change the size
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
