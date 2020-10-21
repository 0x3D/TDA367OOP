package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public final class ModelCanvasTest {
  @Test
  public void addToModel() {
    // Shape shape = new Rectangle();
    ModelCanvas modelCanvas = new ModelCanvas();
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Mshape shape = shapeFactory.createCircle(10, 2, 2, new Color(255, 175, 175), "Circle");
    modelCanvas.addToRender(shape);

    // This will check if got added to list since default position p is (0,0)
    assertEquals(modelCanvas.findShapeAt(2, 2), shape);
  }

  @Test
  public void removeFromModel() {
    // set up
    ModelCanvas modelCanvas = new ModelCanvas();
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Mshape shape = shapeFactory.createCircle(10, 2, 2, new Color(255, 175, 175), "Circle");

    // adding, see test addToModel()
    modelCanvas.addToRender(shape);

    // Removing,
    modelCanvas.removeFromRender(shape);

    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> modelCanvas.findShapeAt(0, 0));
    String expectedMessage = "Shape not found in list";
    assertTrue(exception.getMessage().contains(expectedMessage));
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
    int x = 19;
    int y = 19;
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Mshape shapeToFind = shapeFactory.createRectangle(10, 10, 20, 20, new Color(255, 175, 175), "Rectangle");
    ModelCanvas modelCanvas = new ModelCanvas();
    modelCanvas.addToRender(shapeToFind);
    assertEquals(shapeToFind, modelCanvas.findShapeAt(x, y));
  }

  @Test
  public void testFindShapeAtException() throws IllegalArgumentException {
    int x = 22;
    int y = 22;
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Mshape shapeToFind = shapeFactory.createRectangle(10, 10, 20, 20, new Color(255, 175, 175), "Rectangle");
    ModelCanvas modelCanvas = new ModelCanvas();
    modelCanvas.addToRender(shapeToFind);
    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> modelCanvas.findShapeAt(x, y));
    String exceptionMessage = "Shape not found in list";
    assertTrue(exception.getMessage().contains(exceptionMessage));
  }

  @Test
  public void findCircleAt() {
    int x = 55;
    int y = 55;
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Mshape shapeToFind = shapeFactory.createCircle(10, 50, 50, new Color(255, 175, 175), "Rectangle");
    ModelCanvas modelCanvas = new ModelCanvas();
    modelCanvas.addToRender(shapeToFind);
    assertEquals(shapeToFind, modelCanvas.findShapeAt(x, y));
  }

  @Test
  public void findPolyLineAt() {
    int x = 49;
    int y = 47;
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Mshape shapeToFind = shapeFactory.createLine(10, 10, 50, 50, new Color(255, 175, 175), "Rectangle");
    ModelCanvas modelCanvas = new ModelCanvas();
    modelCanvas.addToRender(shapeToFind);
    assertEquals(shapeToFind, modelCanvas.findShapeAt(x, y));
  }

  @Test
  public void getShapes() {
    // TODO: Implement
  }
}
