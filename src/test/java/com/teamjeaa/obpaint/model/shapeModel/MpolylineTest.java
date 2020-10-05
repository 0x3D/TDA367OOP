package com.teamjeaa.obpaint.model.shapeModel;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MpolylineTest {

  private Mpolyline setUpMpolyline() {
    List<Mpoint> mPoints = new ArrayList<>();
    mPoints.add(new Mpoint(0, 0));
    mPoints.add(new Mpoint(0, 10));
    mPoints.add(new Mpoint(10, 100));
    mPoints.add(new Mpoint(0, 100));
    return new Mpolyline(mPoints);
  }

  @Test
   void getPosition() {
    Mpolyline mpolyline = setUpMpolyline();
    assertEquals(new Mpoint(0, 0), mpolyline.getPosition());
  }

  @Test
   void getWidth() {
    Mpolyline mpolyline = setUpMpolyline();
    assertEquals(mpolyline.getWidth(), 10);
  }

  @Test
  public void getHeight() {
    Mpolyline mpolyline = setUpMpolyline();
    assertEquals(mpolyline.getHeight(),100);
  }

  @Test
  void translate() {
    Mpolyline mpolyline = setUpMpolyline();
    Mshape translated = mpolyline.translate(10,10);
    assertEquals(translated.getPosition().getX(),10);
    assertEquals(translated.getPosition().getY(),10);
  }

  @Test
  void acceptDrawVisitor() {
    //TODO: Implement test for this
  }
  @Test
  void getPoints() {
    Mpolyline mpolyline = setUpMpolyline();
    List<Mpoint> mPoints = new ArrayList<>();
    mPoints.add(new Mpoint(0, 0));
    mPoints.add(new Mpoint(0, 10));
    mPoints.add(new Mpoint(10, 100));
    mPoints.add(new Mpoint(0, 100));
    assertTrue(mpolyline.getPoints().containsAll(mPoints));
  }
}
