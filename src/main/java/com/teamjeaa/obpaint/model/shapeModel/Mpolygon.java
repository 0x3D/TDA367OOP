package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.view.DrawVisistor;

import java.util.List;

/** This class provides what a polygon is in our model */
public class Mpolygon implements Mshape {
  private final List<Mpoint> points;

  Mpolygon(List<Mpoint> points) {
    // TODO: This should make a new list
    this.points = points;
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
  public void acceptDrawVisitor(DrawVisistor drawVisistor) {
    drawVisistor.visitMpolyogon(this);
  }

  @Override
  public Mshape translate(int x, int y) {
    // TODO Auto-generated method stub
    return null;
  }

  public List<Mpoint> getPoints() {
    //this has to duplicate list and points! TODO: implement
    return points;
  }
}
