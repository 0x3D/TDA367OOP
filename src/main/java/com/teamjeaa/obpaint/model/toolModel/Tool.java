package com.teamjeaa.obpaint.model.toolModel;

/**
 * Tool interface that holds the methods that our tools will use
 */
public interface Tool {
  void initialize();

  /**
   * Test method for now
   * @return a size of a tool
   */
  // TODO is this really fitting for public interface?
  int getSize();
}
