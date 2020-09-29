package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.view.DrawVisistor;

import java.awt.*;

public class Mellipse implements Mshape {
  private final Mpoint centerPoint;

  // Semiaxis for x
  private final int semiAxesA;

  // Semiaxis for y
  private final int semiAxesB;

  //Color
  private final Color color;

  Mellipse(Mpoint centerPoint, int semiAxesA, int semiAxesB, Color color) {
    this.centerPoint = centerPoint;
    this.semiAxesA = semiAxesA;
    this.semiAxesB = semiAxesB;
    this.color=color;
  }

  public Color getColor() {
    return color;
  }

  @Override
  public Mpoint getPosition() {
    return this.centerPoint;
  }

  @Override
  public int getWidth() {
    return this.semiAxesA * 2;
  }

  @Override
  public int getHeight() {
    return this.semiAxesB * 2;
  }

  @Override
  public void acceptDrawVisitor(DrawVisistor drawVisistor) {
    drawVisistor.visitMellipse(this);
  }

  public int getSemiAxesA() {
    return semiAxesA;
  }

  public int getSemiAxesB() {
    return semiAxesB;
  }

  @Override
  public Mshape translate(int x, int y) {
    return new Mellipse(new Mpoint(x, y, 0), this.semiAxesA, this.semiAxesB,this.color);
  }
}
