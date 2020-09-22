package com.teamjeaa.obpaint.model.toolModel;

public class ConcreteMoveTool implements Tool {

  @Override
  public void initialize() {
  }

  // TODO is this really fitting for public interface?
  public int getSize() {
    return 0;
  }
}
