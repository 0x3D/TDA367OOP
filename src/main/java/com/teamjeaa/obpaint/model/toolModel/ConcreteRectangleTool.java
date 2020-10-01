package com.teamjeaa.obpaint.model.toolModel;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;

/**
 * A tool to create rectangles at a point, Used by ToolController, Uses MPoint and MShape and
 * Mpolygon
 *
 * @author Erik R
 */
public class ConcreteRectangleTool implements Tool {
  private Mpoint firstVertice;

  /**
   * Start use method is used for our mouseMethods
   *
   * @param x1 will be used by save the start Mouse x pos
   * @param y1 will be used by save the start Mouse y pos
   */
  @Override
  public void startUse(Double x1, Double y1) {
    firstVertice = new Mpoint(x1.intValue(), y1.intValue());
  }

  /**
   * Stop use method is used for our mouseMethods
   *
   * @param x save the end mouse x pos
   * @param y save the end mouse y pos
   * @return A rectangle with sizes you chose with the mouse and a Color
   */
  @Override
  public Mshape stopUse(Double x, Double y) {
    Mpoint secondVertice = new Mpoint(x.intValue(), y.intValue());
    Mpoint fv = firstVertice.clone();
    firstVertice = null;
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    return shapeFactory.createRectangle(
        fv.getX(), fv.getY(), secondVertice.getX(), secondVertice.getY(), Model.getSelectedColor());
  }

  /**
   * Used for get the mousepressed
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
