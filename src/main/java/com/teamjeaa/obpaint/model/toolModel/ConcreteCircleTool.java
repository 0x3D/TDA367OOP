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
public class ConcreteCircleTool implements Tool {
  /** center of the circle */
  Mpoint centerPoint;

  /**
   * Start use method is used for our mouseMethods
   *
   * @param x1 will be used by save the start Mouse x pos
   * @param y1 will be used by save the start Mouse y pos
   */
  @Override
  public void startUse(Double x1, Double y1) {
    centerPoint = new Mpoint(x1.intValue(), y1.intValue());
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
    Mpoint cloneStartCenter = centerPoint.clone();
    int radie =
        (int)
            Math.sqrt(
                Math.pow(cloneStartCenter.getX() - x.intValue(), 2)
                    + Math.pow(cloneStartCenter.getY() - y.intValue(), 2));
    return shapeFactory.createCircle(
        radie, centerPoint.getX(), centerPoint.getY(), Model.getSelectedColor());
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
