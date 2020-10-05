package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.view.DrawVisitor;

import java.util.ArrayList;
import java.util.List;

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

  /**
   * Constructor to create a Polyline
   *
   * @param mPoints List of points to create polyline from
   */
  public Mpolyline(List<Mpoint> mPoints) {
    this.mPoints = mPoints;
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

  /** Return list of all the points that make up polyline
   * @return All the points of the Polyline */
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
    return new Mpolyline(newPolyline);
  }
}
