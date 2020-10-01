package com.teamjeaa.obpaint.model.shapeModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that holds the logic for creating Shapes
 *
 * <p>Responsibility Used by Uses
 *
 * @author Axel H
 * @since 0.1-SNAPSHOT
 */
public class ConcreteShapeFactory implements ShapeFactory {

  /**
   * @param radius
   * @param x
   * @param y
   * @return
   */
  @Override
  public Mshape createCircle(int radius, int x, int y, Color color) {
    return new Mellipse(new Mpoint(x, y, 0), radius, radius, color);
  }

  /**
   * @param x1
   * @param y1
   * @param x2
   * @param y2
   * @return
   */
  @Override
  public Mshape createRectangle(int x1, int y1, int x2, int y2, Color color) {
    List<Mpoint> mpointList = new ArrayList<>();
    mpointList.add(new Mpoint(x1, y1));
    mpointList.add(new Mpoint(x2, y1));
    mpointList.add(new Mpoint(x2, y2));
    mpointList.add(new Mpoint(x1, y2));
    return new Mpolygon(mpointList, color);
  }
}
