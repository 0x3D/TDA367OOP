package com.teamjeaa.obpaint.model.shapeModel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public final class MpointTest {

  @Test
  public void testGetX() {
    Mpoint mpoint = new Mpoint(2, 3);
    assertEquals(mpoint.getX(), 2);
  }

  @Test
  public void testGetY() {
    Mpoint mpoint = new Mpoint(2, 3);
    assertEquals(mpoint.getY(), 3);
  }

  @Test
  public void testTestEquals() {
    Mpoint mpoint1 = new Mpoint(2, 3);
    Mpoint mpoint2 = new Mpoint(2, 3);
    assertEquals(mpoint1, mpoint2);
  }

  @Test
  public void testTestHashCode() {
    // TODO: Implement
  }

  @Test
  public void testTestClone() {
    Mpoint mpoint1 = new Mpoint(2, 3);
    Mpoint mpoint2 = mpoint1.clone();
    assertNotSame(mpoint1, mpoint2);
    assertEquals(mpoint1, mpoint2);
  }
}
