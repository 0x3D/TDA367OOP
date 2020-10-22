package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.view.DrawVisitor;

import com.teamjeaa.obpaint.model.Color;
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
  private int strokeWidth;

  /**
   * Constructor to create a Polyline
   *
   * @param mPoints List of points to create polyline from
   * @param color The color of this Polyline
   */
  public Mpolyline(List<Mpoint> mPoints, Color color, String name, int strokeWidth) {
    this.mPoints = mPoints;
    this.color = color;
    this.name = name;
    this.strokeWidth = strokeWidth;
  }

  /**
   * Color of this Polyline
   *
   * @return The color of the polyline as java.awt color
   */
  public Color getColor() {
    return color;
  }

  public int getStrokeWidth() {
    return strokeWidth;
  }

  @Override
  public String getName() {
    return name;
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
    return new Mpolyline(newPolyline, color, name,strokeWidth);
  }

  @Override
  public boolean isPointMemberOfShape(int x, int y) {
    double acceptance = 10 + this.strokeWidth/2.0;

    /*if (      (x < (getMinPosition().getX() - acceptance) || x > (getMaxPosition().getX()) + acceptance)
            || (y < (getMinPosition().getY() - acceptance) || y > (getMaxPosition().getY()) + acceptance)) {
      return false;
    }*/

    for (int i = 0; i < mPoints.size() - 1; i++) {
      Mpoint point1 = mPoints.get(i);
      Mpoint point2 = mPoints.get(i + 1);

      if (distance(point1, point2, x, y) <= acceptance) {
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
  private double distance(Mpoint point1, Mpoint point2, int x, int y) {
    double distance;
    Mpoint A = point1;
    Mpoint C = point2;
    Mpoint B = new Mpoint(x, y);
    double angleA;
    double angleC;
    double angleB;

    // TODO använda skalärprodukt istället

    double distanceAC = Math.sqrt(Math.pow(C.getX() - A.getX(), 2) + Math.pow(C.getY() - A.getY(), 2));
    double distanceAB = Math.sqrt(Math.pow(B.getX() - A.getX(), 2) + Math.pow(B.getY() - A.getY(), 2));
    double distanceBC = Math.sqrt(Math.pow(B.getX() - C.getX(), 2) + Math.pow(B.getY() - C.getY(), 2));

    angleA = Math.acos((Math.pow(distanceAB, 2) + Math.pow(distanceAC, 2) - Math.pow(distanceBC, 2)) / (2 * distanceAB * distanceAC));
    angleC = Math.acos((Math.pow(distanceBC, 2) + Math.pow(distanceAC, 2) - Math.pow(distanceAB, 2)) / (2 * distanceBC * distanceAC));
    angleB = Math.PI - angleA - angleC;

    distance = Math.sin(angleA) * distanceAB;


    // Change pi to better value
    //and checkif Mouse click is in raduis of a point
    if (angleC >= Math.PI / 3 || angleA >= Math.PI / 3) {
      distance = 999.9;
      return distance;
    }

    return distance;
  }

  private double distanceWithDotProduct(Mpoint point1, Mpoint point2, int x, int y) {
    double distance;
    Mpoint mousePoint = new Mpoint(x, y);

    // vector between point1 and mousePoint
    Mpoint vectorP1MP =
        new Mpoint(Math.abs(mousePoint.getX() - point1.getX()), Math.abs(mousePoint.getY() - point1.getY()));

    // vector between point1 and point2
    Mpoint vectorP1P2 = new Mpoint(Math.abs(point2.getX() - point1.getX()), Math.abs(point2.getY() - point1.getY()));

    double lengthP1MP = Math.sqrt(Math.pow(vectorP1MP.getX(), 2) + Math.pow(vectorP1MP.getY(), 2));
    double lengthP1P2 = Math.sqrt(Math.pow(vectorP1P2.getX(), 2) + Math.pow(vectorP1P2.getY(), 2));

    // dotproduct A * B
    double dotP1MP_P1P2 = vectorP1MP.getX() * vectorP1P2.getX() + vectorP1MP.getY() * vectorP1P2.getY();

    double cosAlpha = dotP1MP_P1P2 / (lengthP1MP * lengthP1P2);
    double angleAlpha = Math.acos(cosAlpha);

    Mpoint vectorP2P1 = new Mpoint(Math.abs(point1.getX() - point2.getX()), Math.abs(point1.getY() - point2.getY()));
    Mpoint vectorP2MP = new Mpoint(Math.abs(mousePoint.getX() - point2.getX()), Math.abs(mousePoint.getY() - point2.getY()));

    double lengthP2P1 = Math.sqrt(Math.pow(vectorP2P1.getX(), 2) + Math.pow(vectorP2P1.getY(), 2));
    double lenghtP2MP = Math.sqrt(Math.pow(vectorP2MP.getX(), 2) + Math.pow(vectorP2MP.getY(), 2));

    double dotP2MP_P2P1 = vectorP2MP.getX() * vectorP2P1.getX() + vectorP2MP.getY() * vectorP2P1.getY();

    double cosBeta = dotP2MP_P2P1 / (lenghtP2MP * lengthP2P1);
    double angleBeta = Math.acos(cosBeta);

    if (angleAlpha <= (Math.PI / 4) && angleBeta <= (Math.PI / 4)) {
      distance = Math.sin(angleAlpha) * lengthP1MP;
    } else {
      distance = 999.9;
    }

    return distance;
  }
}
