package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.view.DrawVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class provides Polyline, a polygon which has 2 unconnected corners.
 *
 * <p>Responsibility Represent a Polyline <br>
 * Used by MpolylineTest<br>
 * Uses
 *
 * @author Erik R
 * @since 0.1-SNAPSHOT
 */
public final class Mpolyline implements Mshape {
  private final List<Mpoint> mPoints;

  private final Color color;
  private final String name;
  private final int strokeWidth;

  /**
   * Constructor to create a Polyline
   *
   * @param mPoints List of points to create polyline from
   * @param color The color of this Polyline
   */
  Mpolyline(final List<Mpoint> mPoints, final Color color, final String name, final int strokeWidth) {
    // Shallow copy but Mpoint is immutable
    this.mPoints = new ArrayList<>(mPoints);
    this.color = color;
    this.name = name;
    this.strokeWidth = strokeWidth;
  }

  /**
   * Color of this Polyline
   *
   * @return The color of the polyline as java.awt color
   */
  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Mpolyline mpolyline = (Mpolyline) o;
    return mPoints.equals(mpolyline.getPoints()) && getColor().equals(mpolyline.getColor());
  }

  @Override
  public int hashCode() {
    return Objects.hash(mPoints, getColor());
  }

  @Override
  public void acceptDrawVisitor(final DrawVisitor drawVisitor) {
    drawVisitor.visitMpolyline(this);
  }

  @Override
  public boolean isPointMemberOfShape(final int x, final int y) {
    final double acceptance = 10 + this.strokeWidth / 2.0;

    for (int i = 0; i < mPoints.size() - 1; i++) {
      final Mpoint point1 = mPoints.get(i);
      final Mpoint point2 = mPoints.get(i + 1);

      if (distance(point1, point2, x, y) <= acceptance) {
        return true;
      } else if (distanceFromPointToCoord(point1, x, y) <= acceptance) {
        return true;
      }
    }
    return false;
  }

  /**
   * Function to get the upper left corner not necessarily on the shape
   *
   * @return An Mpoint which is in the upper left corner,
   */
  public Mpoint getPosition() {
    return getMinPosition();
  }

  private Mpoint getMaxPosition() {
    if (mPoints.isEmpty()) {
      throw new IllegalStateException("Mpolyline has no points, something went terribly wrong");
    }
    int x = mPoints.get(0).getX();
    int y = mPoints.get(0).getY();
    for (final Mpoint mpoint : mPoints) {
      if (mpoint.getX() > x) {
        x = mpoint.getX();
      }
      if (mpoint.getY() > y) {
        y = mpoint.getY();
      }
    }
    return new Mpoint(x, y);
  }

  private Mpoint getMinPosition() {
    if (mPoints.isEmpty()) {
      throw new IllegalStateException("Mpolyline has no points, something went terribly wrong");
    }
    int x = mPoints.get(0).getX();
    int y = mPoints.get(0).getY();
    for (final Mpoint mpoint : mPoints) {
      if (mpoint.getX() < x) {
        x = mpoint.getX();
      }
      if (mpoint.getY() < y) {
        y = mpoint.getY();
      }
    }
    return new Mpoint(x, y);
  }

  /**
   * Width of the Polyline
   *
   * @return int, width of polyline
   */
  public int getWidth() {
    final Mpoint minPoint = getMinPosition();
    final Mpoint maxPoint = getMaxPosition();
    return maxPoint.getX()
        - minPoint.getX(); // Maybe should give an absolute value here since width>0
  }

  /**
   * Height of the Polyline
   *
   * @return int, height of the polyline
   */
  public int getHeight() {
    final Mpoint minPoint = getMinPosition();
    final Mpoint maxPoint = getMaxPosition();
    return maxPoint.getY() - minPoint.getY();
  }

  /**
   * Return list of all the points that make up polyline
   *
   * @return All the points of the Polyline
   */
  public List<Mpoint> getPoints() {
    // this has to duplicate list and points! TODO: implement
    return mPoints;
  }

  /**
   * Translate the Polyline
   *
   * @param x - amount to translate in x direction
   * @param y - amount to translate in y direction
   * @return the translated polyline
   */
  public Mshape translate(final int x, final int y) {
    final List<Mpoint> newPolyline = new ArrayList<>();
    for (final Mpoint mpoint : mPoints) {
      newPolyline.add(new Mpoint(mpoint.getX() + x, mpoint.getY() + y));
    }
    return new Mpolyline(
        newPolyline,
        new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()),
        name,
        strokeWidth);
  }

  private double distanceFromPointToCoord(final Mpoint p, final int x, final int y) {
    final double deltaX = x - p.getX();
    final double deltaY = y - p.getY();
    // Pythagoras
    return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
  }

  /** Distance between a line between two points an another point */
  private double distance(final Mpoint A, final Mpoint C, final int x, final int y) {
    double distance;
    final Mpoint B = new Mpoint(x, y);
    final double angleA;
    final double angleC;

    final double distanceAC =
        Math.sqrt(Math.pow(C.getX() - A.getX(), 2) + Math.pow(C.getY() - A.getY(), 2));
    final double distanceAB =
        Math.sqrt(Math.pow(B.getX() - A.getX(), 2) + Math.pow(B.getY() - A.getY(), 2));
    final double distanceBC =
        Math.sqrt(Math.pow(B.getX() - C.getX(), 2) + Math.pow(B.getY() - C.getY(), 2));

    angleA =
        Math.acos(
            (Math.pow(distanceAB, 2) + Math.pow(distanceAC, 2) - Math.pow(distanceBC, 2))
                / (2 * distanceAB * distanceAC));
    angleC =
        Math.acos(
            (Math.pow(distanceBC, 2) + Math.pow(distanceAC, 2) - Math.pow(distanceAB, 2))
                / (2 * distanceBC * distanceAC));

    distance = Math.sin(angleA) * distanceAB;

    if (angleC >= Math.PI / 3 || angleA >= Math.PI / 3) {
      distance = 999.9;
      return distance;
    }

    return distance;
  }

  public Color getColor() {
    return color;
  }

  public int getStrokeWidth() {
    return strokeWidth;
  }
}
