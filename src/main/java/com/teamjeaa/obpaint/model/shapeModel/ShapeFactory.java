package com.teamjeaa.obpaint.model.shapeModel;

/** Interface that holds the methods for our creating of the Shapes */
public interface ShapeFactory {
  Mshape createCircle(int radius, int x, int y);

  //TODO: cant be same have to handle
  Mshape createRectangle(int x1, int y1, int x2, int y2);

  // Shape createCircle(int x1, int y1, int radius);

  // Shape createRectangle(int x1, int y1, int x2, int y2);

  // Shape createTriangle(double x1, double y1, double x2, double y2, double x3, double y3);
}
