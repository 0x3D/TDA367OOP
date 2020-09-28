package com.teamjeaa.obpaint.model.toolModel;


import javafx.scene.shape.Shape;

/**
 * Tool interface that holds the methods that our tools will use
 */
public interface Tool {
  void initialize();

  void startUse(Double x1, Double y1);

  Shape stopUse(Double x1, Double y1);

  Shape initialMouseClick(double x, double y);

  /**
   * Test method for now
   * @return a size of a tool
   */
  // TODO is this really fitting for public interface?
  int getSize();

}
