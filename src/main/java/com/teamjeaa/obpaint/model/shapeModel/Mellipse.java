package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.view.DrawVisitor;

import java.awt.*;

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
public class Mellipse implements Mshape {
  // Center of ellipse
  private final Mpoint centerPoint;

  // Semi-axes for x
  private final int semiAxesA;

  // Semi-axes for y
  private final int semiAxesB;

  // Color
  private final Color color;

  /**
   * @param centerPoint The point in the center of the Ellipse
   * @param semiAxesA The axis of the ellipse in the y direction
   * @param semiAxesB The axis of the ellipse ion the x direction
   * @param color The color the ellipse created
   */
  Mellipse(Mpoint centerPoint, int semiAxesA, int semiAxesB, Color color) {
    this.centerPoint = centerPoint;
    this.semiAxesA = semiAxesA;
    this.semiAxesB = semiAxesB;
    this.color = color;
  }

  /** @return The color of this Ellipse */
  public Color getColor() {
    return color; // TODO: create a new color instead of giving object reference
  }

  @Override
  public Mpoint getPosition() {
    return this.centerPoint;
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
  public void acceptDrawVisitor(DrawVisitor drawVisitor) {
    drawVisitor.visitMellipse(this);
  }

  /** @return The semi-axes in the x direction */
  public int getSemiAxesA() {
    return semiAxesA;
  }

  /** @return The semi-axes in the y direction */
  public int getSemiAxesB() {
    return semiAxesB;
  }

  @Override
  public Mshape translate(int x, int y) {
    return new Mellipse(new Mpoint(x, y), this.semiAxesA, this.semiAxesB, this.color);
  }
}
