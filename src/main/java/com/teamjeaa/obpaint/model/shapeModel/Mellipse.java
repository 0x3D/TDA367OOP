package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.view.DrawVisitor;

import java.util.Objects;

/**
 * The models implementation of an ellipse
 *
 * <p>Responsibility: Represent an Ellipse in the model <br>
 * Used by ConcreteShapeFactory, DrawVisitor, JavaFXDrawVisitor, MellipseTest <br>
 * Uses MPoint, java.awt.color, DrawVisitor
 *
 * @author Erik R
 * @since 0.1-SNAPSHOT
 */
public final class Mellipse implements Mshape {
  // Center of ellipse
  private final Mpoint centerPoint;

  // Semi-axes for x
  private final int semiAxesA;

  // Semi-axes for y
  private final int semiAxesB;

  // Color
  private final Color color;

  private final String name;

  /**
   * @param centerPoint The point in the center of the Ellipse
   * @param semiAxesA The axis of the ellipse in the x direction
   * @param semiAxesB The axis of the ellipse ion the y direction
   * @param color The color the ellipse created
   */
  Mellipse(final Mpoint centerPoint, final int semiAxesA, final int semiAxesB, final Color color, final String name) {
    this.centerPoint = centerPoint;
    this.semiAxesA = semiAxesA;
    this.semiAxesB = semiAxesB;
    this.color = color;
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Mpoint getPosition() {
    return new Mpoint(centerPoint.getX() - semiAxesA, centerPoint.getY() - semiAxesB);
  }

  @Override
  public int getWidth() {
    return this.semiAxesA * 2;
  }

  @Override
  public int getHeight() {
    return this.semiAxesB * 2;
  }

  @Override
  public void acceptDrawVisitor(final DrawVisitor drawVisitor) {
    drawVisitor.visitMellipse(this);
  }

  @Override
  public Mshape translate(final int x, final int y) {
    return new Mellipse(
        new Mpoint(centerPoint.getX() + x, centerPoint.getY() + y),
        this.semiAxesA,
        this.semiAxesB,
        this.color,
        this.name);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Mellipse mellipse = (Mellipse) o;
    return getSemiAxesA() == mellipse.getSemiAxesA()
        && getSemiAxesB() == mellipse.getSemiAxesB()
        && getCenterPoint().equals(mellipse.getCenterPoint())
        && getColor().equals(mellipse.getColor());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCenterPoint(), getSemiAxesA(), getSemiAxesB(), getColor());
  }

  /**
   * Provides test for the Ellipse. Checks the given points in the ellipse's equation If the
   * equation is <=1 then the given point is inside the region bounded by the ellipse {@inheritDoc}
   */
  @Override
  public boolean isPointMemberOfShape(final int x, final int y) {
    return Math.pow(x - this.getCenterPoint().getX(), 2) / Math.pow(this.getSemiAxesA(), 2)
            + Math.pow(y - getCenterPoint().getY(), 2) / Math.pow(getSemiAxesB(), 2)
        <= 1;
  }

  /**
   * Getter for the Mpoint in the center of ellipse
   *
   * @return centerPoint, a Mpoint which is the middle of the ellipse
   */
  public Mpoint getCenterPoint() {
    return this.centerPoint.clone();
  }

  /** @return The color of this Ellipse */
  public Color getColor() {
    // Color is immutable
    return color;
  }

  /** @return The semi-axes in the x direction */
  public int getSemiAxesA() {
    return semiAxesA;
  }

  /** @return The semi-axes in the y direction */
  public int getSemiAxesB() {
    return semiAxesB;
  }
}
