package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.model.Color;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

final class MellipseTest {
  private final ShapeFactory concreteShapeFactory = new ConcreteShapeFactory();

  Mshape createCircle() {
    // Circle r = 10, y = 20, x = 15
    return concreteShapeFactory.createCircle(10, 15, 20, new Color(255, 175, 175), "Circle");
  }

  //
  @Test
  void testCircleFactory() {
    Mshape c = createCircle();
    assertEquals(Mellipse.class, c.getClass());
  }

  @Test
  void testCircleHeight() {
    Mshape c = createCircle();
    assertEquals(20, c.getHeight());
  }

  @Test
  void testCircleWidth() {
    Mshape c = createCircle();
    assertEquals(20, c.getWidth());
  }

  @Test
  void testMove() {
    Mshape c = createCircle();
    c = c.translate(5, 40);
    assertEquals(10, c.getPosition().getX());
    assertEquals(50, c.getPosition().getY());
  }

  @Test
  void isPointMemberOfShape() {
    Mshape mellipse = new Mellipse(new Mpoint(10, 10), 10, 10, new Color(255, 175, 175), "test");
    assertTrue(mellipse.isPointMemberOfShape(10, 10));
    assertFalse(mellipse.isPointMemberOfShape(21, 10));
    assertFalse(mellipse.isPointMemberOfShape(20, 20));
  }

  @Test
  void getPosition() {
    Mshape circle = createCircle();
    assertEquals(5, circle.getPosition().getX());
    assertEquals(10, circle.getPosition().getY());
  }
}
