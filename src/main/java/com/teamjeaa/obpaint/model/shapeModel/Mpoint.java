package com.teamjeaa.obpaint.model.shapeModel;

import java.util.Objects;

/** Class that represents a point in the model
 *
 * <p>Responsibility Used by Uses
 *
 * @author Erik R
 * @since 0.1-SNAPSHOT
 * */
public class Mpoint implements Cloneable {
  private final int x;
  private final int y;
  private final int z;

  Mpoint(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public Mpoint(int x, int y) {
    this(x, y, 0);
  }

  /** @return The x cordinate of the point in space */
  public int getX() {
    return x;
  }

  /** @return The y cordinate of the point in space */
  public int getY() {
    return y;
  }

  /** @return This could be a third dimension to do buffering */
  private int getZ() {
    return z;
  }

  /**
   * Method that checks if this object is the same as another object
   *
   * @param o Object to check if equal to
   * @return True if equal and false if unequal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Mpoint mPoint = (Mpoint) o;
    return getX() == mPoint.getX() && getY() == mPoint.getY() && getZ() == mPoint.getZ();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getX(), getY(), getZ());
  }

  /** @return A copy of this point */
  @Override
  public Mpoint clone() {
    final Mpoint clone;
    try {
      clone = (Mpoint) super.clone();
    } catch (CloneNotSupportedException ex) {
      throw new RuntimeException("superclass messed up", ex);
    }
    return clone;
  }
}
