package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.model.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that holds the logic for creating Shapes
 *
 * <p>Responsibility Factory class that creates instances of different Mshapes for model. Used by
 * ConcreteCircleTool, ConcreteRectangleTool Uses Color, Mpoint, Mpolygon, Mellipse, some more tools
 * might be added. Uses ShapeFactory Interface.
 *
 * @author Axel H
 * @see Mellipse
 * @see Mpoint
 * @see Mpolygon
 * @see ShapeFactory
 * @see Color
 * @since 0.1-SNAPSHOT
 */
public final class ConcreteShapeFactory implements ShapeFactory {

  @Override
  public Mshape createCircle(final int radius, final int x, final int y, final Color color, final String name) {
    return new Mellipse(new Mpoint(x, y), radius, radius, color, name);
  }

  @Override
  public Mshape createRectangle(final int x1, final int y1, final int x2, final int y2, final Color color, final String name) {
    final List<Mpoint> mpointList = new ArrayList<>();
    mpointList.add(new Mpoint(x1, y1));
    mpointList.add(new Mpoint(x2, y1));
    mpointList.add(new Mpoint(x2, y2));
    mpointList.add(new Mpoint(x1, y2));
    return new Mpolygon(mpointList, color, name);
  }

  @Override
  public Mshape createLine(
          final int x1, final int y1, final int x2, final int y2, final Color color, final String name, final int strokeWidth) {
    final List<Mpoint> mpointList = new ArrayList<>();
    mpointList.add(new Mpoint(x1, y1));
    mpointList.add(new Mpoint(x2, y2));
    return new Mpolyline(mpointList, color, name, strokeWidth);
  }

  @Override
  public Mshape createPolyline(final List<Mpoint> points, final Color color, final String name, final int strokeWidth) {
    return new Mpolyline(points, color, name, strokeWidth);
  }
}
