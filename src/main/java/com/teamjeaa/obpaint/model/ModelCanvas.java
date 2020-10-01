package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to store all the created objects by the user in canvas
 * The class is used by the model class
 *
 * @author Erik R
 * @since 0.1 SNAPSHOT
 *
 */
public class ModelCanvas {

  // TODO: Add ? extends
  private final List<Mshape> shapes;

  private ModelCanvas(List<Mshape> shapes) {
    this.shapes = shapes;
  }

  /**
   * Initializes an empty model canvas object
   */
  public ModelCanvas() {
    this(new ArrayList<>());
  }


  /**
   * Adds a shape to a list with objects created by the user
   *
   * @param shape - The object to be added
   */
  public void addToRender(Mshape shape) {
    this.shapes.add(shape);
  }

  /**
   * Removes a shape from the list with objects created by the user
   *
   * @param shape - The object to be removed from the list
   */
  public void removeFromRender(Mshape shape) {
    this.shapes.remove(shape);
  }

  /**
   * Finds the shape at a specific point (x,y).
   *
   * @param x - Point x
   * @param y - Point y
   * @return - The shape at the point (x,y)
   * @throws IllegalArgumentException
   */
  public Mshape findShapeAt(double x, double y) throws IllegalArgumentException {
    for (Mshape shape : shapes) {
      Mpoint pos = shape.getPosition();
      if (Double.compare(pos.getX(), x) == 0 && Double.compare(pos.getY(), y) == 0) {
        return shape;
      }
    }
    throw new IllegalArgumentException("Object not found");
  }

  /**
   * Getter for the current shapes created
   *
   * @return - A list of the created shapes
   */
  public List<Mshape> getShapes() {
    return shapes;
  }
}
