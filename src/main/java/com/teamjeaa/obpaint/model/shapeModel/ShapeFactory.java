package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.model.Color;

import java.util.List;

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
   *
   * @param radius Radius of the circle
   * @param x x value on screen.
   * @param y y value on screen.
   * @return returns new instance of the Mellipse (circle) class.
   */
  Mshape createCircle(int radius, int x, int y, Color color, String name);


  /**
   * Method used by factory to create a Rectangle.
   *
   * @param x1 X value for point where user starts mouse click.
   * @param y1 Y value for point where user starts mouse click.
   * @param x2 X value for point where user releases mouse.
   * @param y2 Y value for point where user releases mouse.
   * @param color is the color of the rectangle
   * @return returns instance of a Mpolygon.
   */
  Mshape createRectangle(int x1, int y1, int x2, int y2, Color color, String name);

  /**
   * Method used by factory to create a Rectangle.
   *
   * @param x1 X value for point where user starts mouse click.
   * @param y1 Y value for point where user starts mouse click.
   * @param x2 X value for point where user releases mouse.
   * @param y2 Y value for point where user releases mouse.
   * @param color is the color of the line
   * @return returns instance of a Mpolygon.
   */
  Mshape createLine(int x1, int y1, int x2, int y2, Color color, String name);

  /**
   * Method used by factory to create a Polyline.
   *
   * @param points - the points for the line
   * @param color - color of the line
   * @return - an Mshape
   */
  Mshape createPolyline(List<Mpoint> points, Color color, String name);
}
