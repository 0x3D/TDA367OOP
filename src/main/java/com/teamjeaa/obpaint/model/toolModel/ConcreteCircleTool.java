package com.teamjeaa.obpaint.model.toolModel;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;


/** A tool to create a circle at a place in the model */
public class ConcreteCircleTool implements Tool {
  Mpoint centerPoint;

  @Override
  public void startUse(Double x1, Double y1) {
    centerPoint = new Mpoint(x1.intValue(), y1.intValue());
  }

  @Override
  public Mshape stopUse(Double x, Double y) {
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Mpoint cloneStartCenter = centerPoint.clone();
    int radie = (int) Math.sqrt(Math.pow(cloneStartCenter.getX() - x.intValue(), 2) +
            Math.pow(cloneStartCenter.getY() - y.intValue(), 2));
    return shapeFactory.createCircle(radie, centerPoint.getX(), centerPoint.getY(), Model.getSelectedColor());
  }

  @Override
  public Mshape initialMouseClick(double x, double y) {
    return null;
  }
}
