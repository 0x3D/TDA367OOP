package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.model.shapeModel.Mshape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is used to store all the created objects by the user in canvas The class is used by
 * the model class
 *
 * @author Erik R
 * @since 0.1 SNAPSHOT
 */
public final class ModelCanvas {

  // Can't use generics because read and write out of list
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
   */
  public void removeFromRender(Mshape mshape) {
    this.shapes.remove(mshape);
  }

  /**
   * Finds the shape at a specific point (x,y). We reverse the list to get the latest Shape
   *
   * @param x - Point x
   * @param y - Point y
   * @return - The shape at the point (x,y)
   * @throws IllegalArgumentException If Shape is not in list
   */
  public Mshape findShapeAt(int x, int y) throws IllegalArgumentException {
    // Maybe not optimal solution
    Collections.reverse(shapes);
    for (Mshape shape : shapes) {
      if (shape.isPointMemberOfShape(x, y)) {
        Collections.reverse(shapes);
        return shape;
      }
    }
    Collections.reverse(shapes);
    throw new IllegalArgumentException("Shape not found in list, ModelCanvas");
  }

  /**
   * Getter for the current shapes created
   *
   * @return - A list of the created shapes
   */
  public List<Mshape> getShapes() {
    // Unmodifiable list so that any that uses the models list can't change it
    return Collections.unmodifiableList(shapes);
  }

  void resetRenderList() {
    shapes.clear();
  }
}
