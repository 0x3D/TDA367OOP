package com.teamjeaa.obpaint.model.shapeModel;

import java.util.List;

public class Mpolygon implements Mshape{
  private final List<Mpoint> points;

  private Mpolygon(List<Mpoint> points) {
    this.points = points;
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
