package com.teamjeaa.obpaint.model;

import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class ModelCanvas {

  // TODO: Add ? extends
  private final List<Shape> shapes;
  private final List<? extends Updateable> updateables;

  private ModelCanvas(List<Shape> shapes, List<? extends Updateable> updateables) {
    this.shapes = shapes;
    this.updateables = updateables;
  }
  public ModelCanvas() {
    this(new ArrayList<>(), new ArrayList<>());

  }

  public void addToRender(Shape shape) {
    this.shapes.add(shape);
  }

  // TODO: Implement
  public void removeFromRender(Shape shape) {}

  public Shape findShapeAt(double x, double y) throws IllegalArgumentException {
    for (Shape shape : shapes) {
      // TODO:fix this
      if (Double.compare(shape.getTranslateX(), x) == 0
          && Double.compare(shape.getTranslateY(), y) == 0) {
        return shape;
      }
    }
    throw new IllegalArgumentException("Object not found");
  }
}
