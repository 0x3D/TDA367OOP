package com.teamjeaa.obpaint.model.toolModel;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;

/**
 * ConcreteCircleTool to create a circle at a place in the model Used by ToolController.java Uses
 * Mpoint and Mshape and MEllipse
 *
 * @author Axel H
 */
public final class ConcreteCircleTool implements Tool {
  /** center of the circle */
  Mpoint startPoint;

  /**
   * Start use method is used for our mouseMethods
   *
   * @param x1 will be used by save the start Mouse x pos
   * @param y1 will be used by save the start Mouse y pos
   */
  @Override
  public void startUse(Double x1, Double y1) {
    startPoint = new Mpoint(x1.intValue(), y1.intValue());
  }

  /**
   * Stop use method is used for our mouseMethods
   *
   * @param x save the end mouse x pos
   * @param y save the end mouse y pos
   * @return A circle with the sizes you chose with the mouse and a Color
   */
  @Override
  public Mshape stopUse(Double x, Double y) {
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    int dia = (int) Math.sqrt(Math.pow(startPoint.getX() - x.intValue(), 2) + Math.pow(startPoint.getY() - y.intValue(), 2));
    Mpoint centerPoint = new Mpoint((startPoint.getX() + x.intValue())/2, (startPoint.getY() + y.intValue())/2);

    return shapeFactory.createCircle(
        dia/2, centerPoint.getX(), centerPoint.getY(), Model.getSelectedColor());
  }

  /**
   * Used for get the mouse pressed
   *
   * @param x position
   * @param y position
   * @return null for now
   */
  @Override
  public Mshape initialMouseClick(double x, double y) {
    return null;
  }
}
