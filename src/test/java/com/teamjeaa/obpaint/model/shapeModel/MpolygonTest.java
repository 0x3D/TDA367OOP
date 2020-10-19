package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.model.Color;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class MpolygonTest {

  @Test
  public void testGetPosition() {
    List<Mpoint> mpointList = new ArrayList<>();
    mpointList.add(new Mpoint(0, 0));
    mpointList.add(new Mpoint(1, 1));
    Mpolygon mpolygon = new Mpolygon(mpointList, new Color(255, 175, 175), "test");
    assertEquals(mpolygon.getPosition().getX(), 0);
    assertEquals(mpolygon.getPosition().getY(), 0);
  }

  @Test
  public void testGetWidth() {
    List<Mpoint> mpointList = new ArrayList<>();
    mpointList.add(new Mpoint(0, 0));
    mpointList.add(new Mpoint(2, 2));
    Mpolygon mpolygon = new Mpolygon(mpointList, new Color(255, 175, 175),"test");
    assertEquals(mpolygon.getWidth(), 2);
  }

  @Test
  public void testGetHeight() {
    List<Mpoint> mpointList = new ArrayList<>();
    mpointList.add(new Mpoint(0, 0));
    mpointList.add(new Mpoint(2, 3));
    Mpolygon mpolygon = new Mpolygon(mpointList, new Color(255, 175, 175), "test");
    assertEquals(mpolygon.getHeight(), 3);
  }
}
