package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.view.DrawVisitor;

import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
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

  /**
   * Constructor to create a Polyline
   *
   * @param mPoints List of points to create polyline from
   * @param color The color of this Polyline
   */
  public Mpolyline(List<Mpoint> mPoints, Color color) {
    this.mPoints = mPoints;
    this.color = color;
  }

  /**
   * Color of this Polyline
   *
   * @return The color of the polyline as java.awt color
   */
  public Color getColor() {
    return color;
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
    if (mPoints == null) {
      throw new IllegalStateException("Mpolyline has no points, something went terribly wrong");
    }
    int x = mPoints.get(0).getX();
    int y = mPoints.get(0).getY();
    for (Mpoint mpoint : mPoints) {
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
    if (mPoints == null) {
      throw new IllegalStateException("Mpolyline has no points, something went terribly wrong");
    }
    int x = mPoints.get(0).getX();
    int y = mPoints.get(0).getY();
    for (Mpoint mpoint : mPoints) {
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
    Mpoint minPoint = getMinPosition();
    Mpoint maxPoint = getMaxPosition();
    return maxPoint.getX()
        - minPoint.getX(); // Maybe should give an absolute value here since width>0
  }

  /**
   * Height of the Polyline
   *
   * @return int, hieght of the polyline
   */
  public int getHeight() {
    Mpoint minPoint = getMinPosition();
    Mpoint maxPoint = getMaxPosition();
    return maxPoint.getY() - minPoint.getY();
  }

  @Override
  public void acceptDrawVisitor(DrawVisitor drawVisitor) {
    drawVisitor.visitMpolyline(this);
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
  public Mshape translate(int x, int y) {
    List<Mpoint> newPolyline = new ArrayList<>();
    for (Mpoint mpoint : mPoints) {
      newPolyline.add(new Mpoint(mpoint.getX() + x, mpoint.getY() + y));
    }
    // TODO: New color not old reference
    return new Mpolyline(newPolyline, color);
  }

  @Override
  public boolean isPointMemberOfShape(int x, int y) {
    // TODO Add (thickness of the line)/2 to get the right acceptance
    int acceptance = 7;

    /*if (      (x < (getMinPosition().getX() - acceptance) || x > (getMaxPosition().getX()) + acceptance)
            || (y < (getMinPosition().getY() - acceptance) || y > (getMaxPosition().getY()) + acceptance)) {
      return false;
    }*/

    for (int i = 0; i < mPoints.size() - 1; i++) {
      Mpoint point1 = mPoints.get(i);
      Mpoint point2 = mPoints.get(i + 1);

      if (distance(point1, point2, x, y) < acceptance) {
        //System.out.println(distance(point1,point2, x, y));
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Mpolyline mpolyline = (Mpolyline) o;
    return mPoints.equals(mpolyline.mPoints) && getColor().equals(mpolyline.getColor());
  }

  @Override
  public int hashCode() {
    return Objects.hash(mPoints, getColor());
  }

  /** https://en.wikipedia.org/wiki/Distance_from_a_point_to_a_line */
  private int distance(Mpoint point1, Mpoint point2, int x, int y){
    int distance;
    Mpoint A = point1;
    Mpoint C = point2;
    Mpoint B = new Mpoint(x, y);
    double angleA;
    double angleC;
    double angleB;

    //TODO använda skalärprodukt istället

    double distanceAC = Math.sqrt(Math.pow(C.getX()-A.getX(), 2) + Math.pow(C.getY() - A.getY(), 2));
    double distanceAB = Math.sqrt(Math.pow(B.getX()-A.getX(), 2) + Math.pow(B.getY() - A.getY(), 2));
    double distanceBC = Math.sqrt(Math.pow(B.getX()-C.getX(), 2) + Math.pow(B.getY() - C.getY(), 2));

    angleA = Math.acos((Math.pow(distanceAB, 2) + Math.pow(distanceAC, 2) - Math.pow(distanceBC, 2)) / (2 * distanceAB * distanceAC));
    angleC = Math.acos((Math.pow(distanceBC, 2) + Math.pow(distanceAC, 2) - Math.pow(distanceAB, 2)) / (2 * distanceBC * distanceAC));
    angleB = Math.PI - angleA - angleC;

    distance = (int) Math.round(Math.sin(angleA) * distanceAB);

    if (angleC >= Math.PI/4 || angleA >= Math.PI/4) {
      distance = 99;
      return distance;
    }

    return distance;
  }
}
