package com.teamjeaa.obpaint.model.toolModel;

import com.teamjeaa.obpaint.model.shapeModel.Mshape;

/**
 * Tool interface that holds the methods that our tools will use, Used by ConcreteBrush,
 * ConcreteCircleTool, ConcreteEraser, ConcreteMoveTool, ConcretePencil and ConcreteRectangleTool,
 * Uses Mshape and Functions from the mouse in JavaFx.
 *
 * @author Jonas N
 * @see ConcreteCircleTool
 * @see ConcreteBrush
 * @see ConcreteEraser
 * @see ConcreteMoveTool
 * @see ConcretePencil
 * @see ConcreteRectangleTool
 */
public interface Tool {
  /**
   * StartUse is a method that takes the mouse position x1 and y1, and we define what startUse
   * should do on the object that implements this Interface.
   *
   * @param x1 the x value (Mainly from the mouse)
   * @param y1 the y value (Mainly from the mouse)
   */
  void startUse(Double x1, Double y1);

  /**
   * StopUse method is a method that is called when we stopped use the mouse to "Paint" a object in
   * our Canvas. When this is called we tell what a object to create
   *
   * @param x1 x value of the endPoint of the mouse
   * @param y1 y value of the endPoint of the mouse
   * @return MShape type of object that can be any of our concrete shapes
   */
  Mshape stopUse(Double x1, Double y1);

  /**
   * Method that says what to do on mouse pressed. Not used much for now, but we think we need to
   * have it for the future
   *
   * @param x mouse value of x
   * @param y mouse value of y
   * @return Mshape for now
   */
  Mshape initialMouseClick(double x, double y);
}
