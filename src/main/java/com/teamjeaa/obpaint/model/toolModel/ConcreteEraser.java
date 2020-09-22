package com.teamjeaa.obpaint.model.toolModel;

public class ConcreteEraser implements Tool {
  private final int size;

  public ConcreteEraser(int size) {
    this.size = size;
  }

  @Override
  public void initialize() {
  }

  // TODO is this really fitting for public interface?
  public int getSize() {
    return size;
  }
}
