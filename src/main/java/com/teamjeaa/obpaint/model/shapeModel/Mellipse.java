package com.teamjeaa.obpaint.model.shapeModel;

public class Mellipse implements Mshape {
  private final Mpoint centerPoint;

  //Semiaxis for x
  private final int semiAxesA;

  //Semiaxis for y
  private final int SemiAxesB;

  Mellipse(Mpoint centerPoint, int semiAxesA, int semiAxesB) {
    this.centerPoint = centerPoint;
    this.semiAxesA = semiAxesA;
    SemiAxesB = semiAxesB;
  }

  @Override
  public Mpoint getPosition() {
    return null;
  }

  @Override
  public int getWidth() {
    return 0;
  }

  @Override
  public int getHeight() {
    return 0;
  }
}
