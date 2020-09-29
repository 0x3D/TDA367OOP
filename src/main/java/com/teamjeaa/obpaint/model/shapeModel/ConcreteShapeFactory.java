package com.teamjeaa.obpaint.model.shapeModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/** Class that holds the logic for all our creating of Shapes */
public class ConcreteShapeFactory implements ShapeFactory {
  //
  //    /**
  //     * TODO
  //     * @param x1
  //     * @param y1
  //     * @param x2
  //     * @param y2
  //     * @param x3
  //     * @param y3
  //     * @return the Triangle as a Polygon
  //     */
  //    public Shape createTriangle(double x1, double y1, double x2, double y2, double x3, double
  // y3) {
  //        return new Polygon();
  //    }
  //
  //    /**
  //     * TODO
  //     * @param x1
  //     * @param y1
  //     * @param x2
  //     * @param y2
  //     * @return The Rectangle
  //     */
  //    public Shape createRectangle(int x1, int y1, int x2, int y2) {
  //        return new Rectangle();
  //    }

  /**
   * @param radius
   * @param x
   * @param y
   * @return
   */
  @Override
  public Mshape createCircle(int radius, int x, int y) {
    return new Mellipse(new Mpoint(x, y, 0), radius, radius);
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
    mpointList.add(new Mpoint(x1,y1));
    mpointList.add(new Mpoint(x2,y1));
    mpointList.add(new Mpoint(x2,y2));
    mpointList.add(new Mpoint(x1,y2));
    return new Mpolygon(mpointList, color);
  }


}
