package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.model.shapeModel.ShapeUtil;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.geometry.Point3D;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * //TODO
 */
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
      Point3D point3D = ShapeUtil.getPosOfShape(shape);

      if (Double.compare(point3D.getX(), x) == 0
          && Double.compare(point3D.getY(), y) == 0) {
        return shape;
      }
    }
    throw new IllegalArgumentException("Object not found");
  }
}
