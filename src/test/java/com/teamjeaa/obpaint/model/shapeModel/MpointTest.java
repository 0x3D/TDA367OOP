package com.teamjeaa.obpaint.model.shapeModel;

import org.junit.Assert;
import org.junit.Test;

public class MpointTest {

  @Test
  public void testGetX() {
    Mpoint mpoint = new Mpoint(2,3,0);
    Assert.assertEquals(mpoint.getX(), 2);
  }

  @Test
  public void testGetY() {
    Mpoint mpoint = new Mpoint(2,3,0);
    Assert.assertEquals(mpoint.getY(), 3);
  }

  @Test
  public void testTestEquals() {
    Mpoint mpoint1 = new Mpoint(2,3,0);
    Mpoint mpoint2 = new Mpoint(2,3,0);
    Assert.assertEquals(mpoint1, mpoint2);
  }

  @Test
  public void testTestHashCode() {

  }

  @Test
  public void testTestClone() {
    Mpoint mpoint1 = new Mpoint(2,3,0);
    Mpoint mpoint2 = mpoint1.clone();
    Assert.assertNotSame(mpoint1, mpoint2);
    Assert.assertEquals(mpoint1,mpoint2);

  }
}