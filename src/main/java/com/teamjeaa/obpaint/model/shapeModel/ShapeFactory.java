package com.teamjeaa.obpaint.model.shapeModel;

import java.awt.*;

/**
 * Interface that holds the methods for creating the Shapes *
 *
 * <p>Responsibility Used by Uses
 *
 * @author Axel H
 * @since 0.1-SNAPSHOT
 */
public interface ShapeFactory {

  /**
   * Concrete factory uses method to create a Circle
   * @param radius Radius of the circle
   * @param x x value on screen.
   * @param y y value on screen.
   * @return returns new instance of the Mellipse (circle) class.
   */
  Mshape createCircle(int radius, int x, int y, Color color);

  // TODO: cant be same have to handle

  /**
   * Method used by factory to create a Rectangle.
   * @param x1 X value for point where user starts mouse click.
   * @param y1 Y value for point where user starts mouse click.
   * @param x2 X valie for point where user releases mouse.
   * @param y2 Y value for point where user releases mouse.
   * @return returns instance of a Mpolygon.
   */

  Mshape createRectangle(int x1, int y1, int x2, int y2, Color color);

  // Shape createCircle(int x1, int y1, int radius);

  // Shape createRectangle(int x1, int y1, int x2, int y2);

  // Shape createTriangle(double x1, double y1, double x2, double y2, double x3, double y3);
}
