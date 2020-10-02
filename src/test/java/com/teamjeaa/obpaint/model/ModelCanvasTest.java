package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class ModelCanvasTest {
  @Test
  public void addToModel() {
    // Shape shape = new Rectangle();
    ModelCanvas modelCanvas = new ModelCanvas();
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Mshape shape = shapeFactory.createCircle(10, 2, 2, Color.BLACK);
    modelCanvas.addToRender(shape);

    // This will check if got added to list since default position p is (0,0)
    Assert.assertEquals(modelCanvas.findShapeAt(2-10,2-10 ), shape);
  }

  @Test(expected = IllegalArgumentException.class)
  public void removeFromModel() throws IllegalArgumentException {
    // set up
    ModelCanvas modelCanvas = new ModelCanvas();
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Mshape shape = shapeFactory.createCircle(10, 2, 2, Color.BLACK);

    // adding, see test addToModel()
    modelCanvas.addToRender(shape);

    // Removing,
    modelCanvas.removeFromRender(shape);

    Mshape secondShape = modelCanvas.findShapeAt(0, 0);
  }

  @Test
  public void addToRender() {
    // TODO: Implement
  }

  @Test
  public void removeFromRender() {
    // TODO: Implement
  }

  @Test
  public void findShapeAt() {
    // TODO: Implement
  }

  @Test
  public void getShapes() {
    // TODO: Implement
  }
}
