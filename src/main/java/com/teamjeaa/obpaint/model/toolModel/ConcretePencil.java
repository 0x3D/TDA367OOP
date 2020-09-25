package com.teamjeaa.obpaint.model.toolModel;

import javafx.scene.shape.Shape;

/**
 * Class that holds the logic of out pencil
 */
public class ConcretePencil implements Tool {
  /**
   * Instance of the size of the pencil
   */
  private final int size;

  /**
   * Constructor for our pencil
   * @param size of the pencil
   */
  public ConcretePencil(int size) {
    this.size = size;
    initialize();
  }

  /**
   * initializing our pencil
   */
  @Override
  public void initialize() {

  }

  @Override
  public void startUse(Double x1, Double y1) {

  }

  @Override
  public Shape stopUse(Double x1, Double y1) {
    return null;
  }

  /**
   * getter for the pencilSize
   * Most for the tests
   * @return size of the pencil
   */
  // TODO is this really fitting for public interface?
  public int getSize() {
    return size;
  }


}
