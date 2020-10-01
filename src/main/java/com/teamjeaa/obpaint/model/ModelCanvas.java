package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;

import java.util.ArrayList;
import java.util.List;

/** This class saves every object in our model */
public class ModelCanvas {

  // TODO: Add ? extends
  private final List<Mshape> shapes;

  private ModelCanvas(List<Mshape> shapes) {
    this.shapes = shapes;
  }

  public ModelCanvas() {
    this(new ArrayList<>());
  }

  public void addToRender(Mshape shape) {
    this.shapes.add(shape);
  }

  // TODO: Implement
  public void removeFromRender(Mshape shape) {
    this.shapes.remove(shape);
  }

  public Mshape findShapeAt(double x, double y) throws IllegalArgumentException {
    for (Mshape shape : shapes) {
      Mpoint pos = shape.getPosition();

      if (Double.compare(pos.getX(), x) == 0 && Double.compare(pos.getY(), y) == 0) {
        return shape;
      }
    }
    throw new IllegalArgumentException("Object not found");
  }

  // Not my proudest solution but
  public List<Mshape> getShapes() {
    return shapes;
  }
}
