package com.teamjeaa.obpaint.model.shapeModel;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public final class MellipseTest {
  private final ConcreteShapeFactory concreteShapeFactory = new ConcreteShapeFactory();

  public Mshape createCircle() {
    // Circle r = 10, y = 20, x = 15
    return concreteShapeFactory.createCircle(10, 15, 20, Color.BLACK);
  }

  //
  @Test
  public void testCircleFactory() {
    Mshape c = createCircle();
    assertEquals(Mellipse.class, c.getClass());
  }

  @Test
  public void testCircleHeight() {
    Mshape c = createCircle();
    assertEquals(20, c.getHeight());
  }

  @Test
  public void testCircleWidth() {
    Mshape c = createCircle();
    assertEquals(20, c.getWidth());
  }

  @Test
  public void testMove() {
    Mshape c = createCircle();
    c = c.translate(5, 40);
    assertEquals(10, c.getPosition().getX());
    assertEquals(50, c.getPosition().getY());
  }

  @Test
  void isPointMemberOfShape() {
    Mshape mellipse = new Mellipse(new Mpoint(10, 10), 10, 10, Color.black);
    assertTrue(mellipse.isPointMemberOfShape(10, 10));
    assertFalse(mellipse.isPointMemberOfShape(21, 10));
    assertFalse(mellipse.isPointMemberOfShape(20, 20));
  }

  @Test
  void getPosition() {
    Mshape circle = createCircle();
    assertEquals(5,circle.getPosition().getX());
    assertEquals(10,circle.getPosition().getY());
  }
}
