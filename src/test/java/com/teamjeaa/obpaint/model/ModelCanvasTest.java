package com.teamjeaa.obpaint.model;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.Assert;
import org.junit.Test;

public class ModelCanvasTest {
  @Test
  public void addToModel() {
    Shape shape = new Rectangle();
    ModelCanvas modelCanvas = new ModelCanvas();
    modelCanvas.addToRender(shape);

    // This will check if got added to list since default position p is (0,0)
    Assert.assertEquals(modelCanvas.findShapeAt(0, 0), shape);
  }
}
