package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;

import java.util.ArrayList;
import java.util.List;

// import javafx.geometry.Point3D;
// import javafx.scene.canvas.Canvas;
// import javafx.scene.shape.Shape;

/** //TODO */
public class ModelCanvas {

  // TODO: Add ? extends
  private final List<Mshape> shapes;
  // TODO: Fix typo here
  private final List<? extends Updateable> updateables;

  private ModelCanvas(List<Mshape> shapes, List<? extends Updateable> updateables) {
    this.shapes = shapes;
    this.updateables = updateables;
  }

  public ModelCanvas() {
    this(new ArrayList<>(), new ArrayList<>());
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
