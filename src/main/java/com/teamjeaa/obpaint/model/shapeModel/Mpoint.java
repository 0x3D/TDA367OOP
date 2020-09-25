package com.teamjeaa.obpaint.model.shapeModel;

import java.util.Objects;

public class Mpoint {
  private final int x;
  private final int y;
  private final int z;

  Mpoint(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  private int getX() {
    return x;
  }

  private int getY() {
    return y;
  }

  private int getZ() {
    return z;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Mpoint mPoint = (Mpoint) o;
    return getX() == mPoint.getX() &&
            getY() == mPoint.getY() &&
            getZ() == mPoint.getZ();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getX(), getY(), getZ());
  }

  @Override
  public Mpoint clone(){
    return new Mpoint(x,y,z);
  }


}
