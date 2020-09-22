package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import javafx.scene.shape.Shape;
import org.junit.Assert;
import org.junit.Test;

public class shapeTest {
  ConcreteShapeFactory concreteShapeFactory = new ConcreteShapeFactory();

  public Shape createTriangle() {
    // TODO: move creation logic to new factory
    // Polygon triangle = (Polygon) concreteShapeFactory.createTriangle();
    // triangle.getPoints().addAll(50.0, 0.0,  0.0, 50.0,100.0, 50.0);
    // return triangle;
    return null;
  }

  public Shape createCircle() {
    Shape circle = concreteShapeFactory.createCircle(20, 20, 10);
    return circle;
  }

  public Shape createRectangle() {
    Shape rectangle = concreteShapeFactory.createRectangle(80, 40, 20, 10);
    return rectangle;
  }

  @Test
  public void testMove() {
    Shape rectangle = createRectangle();
    rectangle.setTranslateX(20);
    rectangle.setTranslateY(20);
    // rectangle.translateXProperty().setValue(20);
    // TODO: Fix this test to better try if object has moved.
    int sumX = (int) rectangle.getTranslateX();
    // System.out.println(sumX);
    Assert.assertEquals(sumX, 20.0, 0.5);
  }
}
