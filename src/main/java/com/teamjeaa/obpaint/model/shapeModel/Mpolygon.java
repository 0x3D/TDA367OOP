package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.view.DrawVisitor;

import java.awt.*;
import java.util.List;

/**
 * This class provides polygon in our model
 *
 * <p>Responsibility Represent a Polygon <br>
 * Used by ConcreteShapeFactory, JavaFXDrawVisitor, DrawVisitor, MpolygonTest <br>
 * Uses java.util.List, java.awt, Mshape, Mpoint, DrawVisitor
 *
 * @author Erik R
 * @since 0.1-SNAPSHOT
 */
public final class Mpolygon implements Mshape {
  private final List<Mpoint> points;
  private final Color color;

  /**
   * @param points A list of Mpoints which makes up the polygon
   * @param color The color of the polygon
   */
  Mpolygon(List<Mpoint> points, Color color) {
    // TODO: This should make a new list
    this.points = points;
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  /** @return the point in the upper left corner, not necessarily on the figure */
  @Override
  public Mpoint getPosition() {
    return getMinPosition();
  }

  /** @return The point that are in the upper left corner */
  private Mpoint getMinPosition() {
    assert points.get(0) != null;
    int minX = points.get(0).getX();
    int minY = points.get(0).getY();
    for (Mpoint mpoint : points) {
      minX = Math.min(mpoint.getX(), minX);
      minY = Math.min(mpoint.getY(), minY);
    }
    return new Mpoint(minX, minY);
  }

  /** @return the point in the lower right corner */
  private Mpoint getMaxPosition() {
    assert points.get(0) != null;
    int maxX = points.get(0).getX();
    int maxY = points.get(0).getY();
    for (Mpoint mpoint : points) {
      maxX = Math.max(mpoint.getX(), maxX);
      maxY = Math.max(mpoint.getY(), maxY);
    }
    return new Mpoint(maxX, maxY);
  }

  /** @return The width of the rectangle around the polygon */
  @Override
  public int getWidth() {
    Mpoint minPoint = getMinPosition();
    Mpoint maxPoint = getMaxPosition();
    return maxPoint.getX() - minPoint.getX();
  }

  /** @return The height of the rectangle around the polygon */
  @Override
  public int getHeight() {
    Mpoint minPoint = getMinPosition();
    Mpoint maxPoint = getMaxPosition();
    return maxPoint.getY() - minPoint.getY();
  }

  @Override
  public void acceptDrawVisitor(DrawVisitor drawVisitor) {
    drawVisitor.visitMpolyogon(this);
  }

  @Override
  public Mshape translate(int x, int y) {
    // TODO Auto-generated method stub
    return null;
  }

  //@Override
  public boolean isPointMemberOfShape(int x, int y) {
      if((x >= getMinPosition().getX() && x <= getMaxPosition().getX())
          && (y >= getMinPosition().getY() && y <= getMaxPosition().getY())){
        return true;
      }
    return false;
  }

  /** @return All the points of the Polygon */
  public List<Mpoint> getPoints() {
    // this has to duplicate list and points! TODO: implement
    return points;
  }
}
