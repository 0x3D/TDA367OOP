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
public final class Mpoint implements Cloneable {

  private final int x;
  private final int y;

  /**
   * @param x x coordinate of the point created
   * @param y y coordinate of the point created
   */
  public Mpoint(final int x, final int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Method that checks if this object is the same as another object
   *
   * @param o Object to check if equal to
   * @return True if equal and false if unequal
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Mpoint mPoint = (Mpoint) o;
    return getX() == mPoint.getX() && getY() == mPoint.getY();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getX(), getY());
  }

  /** @return A copy of this point */
  @Override
  public Mpoint clone() {
    final Mpoint clone;
    try {
      clone = (Mpoint) super.clone();
    } catch (final CloneNotSupportedException ex) {
      throw new RuntimeException("superclass messed up", ex);
    }
    return clone;
  }

  /** @return The x coordinate of the point */
  public int getX() {
    return x;
  }

  /** @return The y coordinate of the point */
  public int getY() {
    return y;
  }
}
