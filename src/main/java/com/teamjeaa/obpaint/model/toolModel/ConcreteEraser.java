package com.teamjeaa.obpaint.model.toolModel;

/**
 * Eraser class that holds the EraserLogic
 */
public class ConcreteEraser implements Tool {
  /**
   * Size og the eraser. Final because we want to create a new eraser everytime we change the size
   */
  private final int size;

  /**
   * Constructor for our eraser
   * @param size of the eraser
   */
  public ConcreteEraser(int size) {
    this.size = size;
  }

  /**
   * initializing the eraser
   */
  @Override
  public void initialize() {
  }

  /**
   * getter for the size of the eraser
   * @return size of the eraser
   */
  // TODO is this really fitting for public interface?
  public int getSize() {
    return size;
  }
}
