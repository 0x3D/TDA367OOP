package com.teamjeaa.obpaint.model.toolModel;

public class ConcretePencil implements Tool {
  private final int size;

  public ConcretePencil(int size) {
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
