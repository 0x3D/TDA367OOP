package com.teamjeaa.obpaint.model.shapeModel;

public interface Mpoint extends Cloneable {
  /** @return The x coordinate of the point */
  int getX();

  /** @return The y coordinate of the point */
  int getY();

  /** @return This could be a third dimension to do buffering */
  int getZ();

  /**
   * Method that checks if this object is the same as another object
   *
   * @param o Object to check if equal to
   * @return True if equal and false if unequal
   */
  @Override
  boolean equals(Object o);

  @Override
  int hashCode();

  Mpoint clone();
}
