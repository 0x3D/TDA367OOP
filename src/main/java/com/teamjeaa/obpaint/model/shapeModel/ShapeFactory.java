package com.teamjeaa.obpaint.model.shapeModel;

import java.awt.*;

/** Interface that holds the methods for our creating of the Shapes */
public interface ShapeFactory {
  Mshape createCircle(int radius, int x, int y, Color color);

  //TODO: cant be same have to handle
  Mshape createRectangle(int x1, int y1, int x2, int y2, Color color);

  // Shape createCircle(int x1, int y1, int radius);

  // Shape createRectangle(int x1, int y1, int x2, int y2);

  // Shape createTriangle(double x1, double y1, double x2, double y2, double x3, double y3);
}
