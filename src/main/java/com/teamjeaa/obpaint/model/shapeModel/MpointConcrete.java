package com.teamjeaa.obpaint.model.shapeModel;

import java.util.Objects;

/**
 * Class that represents a point in the model
 *
 * <p>Responsibility Represent a point <br>
 * Used by ConcreteShapeFactory, Mellipse, Mpolygon, Mshape, ConcreteCircleTool, MpointTest
 * ConcreteRectangleTool, ModelCanvas, JavaFXDrawVisitor <br>
 * Uses java.util.Objects
 *
 * @author Erik R
 * @since 0.1-SNAPSHOT
 */
public final class MpointConcrete implements Mpoint {
  private final int x;
  private final int y;
  private final int z;

  /**
   * @param x x coordinate of the point created
   * @param y y coordinate of the point created
   * @param z z coordinate of the point created
   */
  private MpointConcrete(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * @param x x coordinate of the point created
   * @param y y coordinate of the point created
   */
  public MpointConcrete(int x, int y) {
    this(x, y, 0);
  }

  /** @return The x coordinate of the point */
  @Override
  public int getX() {
    return x;
  }

  /** @return The y coordinate of the point */
  @Override
  public int getY() {
    return y;
  }

  /** @return This could be a third dimension to do buffering */
  @Override
  public int getZ() {
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
