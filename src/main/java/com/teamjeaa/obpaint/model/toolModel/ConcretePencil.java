package com.teamjeaa.obpaint.model.toolModel;

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
  }

  /**
   * initializing our pencil
   */
  @Override
  public void initialize() {
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
