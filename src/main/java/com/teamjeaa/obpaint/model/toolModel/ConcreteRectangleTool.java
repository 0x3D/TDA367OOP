package com.teamjeaa.obpaint.model.toolModel;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;

/** A tool to create rectangles at a point */
public class ConcreteRectangleTool implements Tool {
  private Mpoint firstVertice;

  @Override
  public void startUse(Double x1, Double y1) {
    firstVertice = new Mpoint(x1.intValue(), y1.intValue());
  }

  @Override
  public Mshape stopUse(Double x, Double y) {
    Mpoint secondVertice = new Mpoint(x.intValue(), y.intValue());
    Mpoint fv = firstVertice.clone();
    firstVertice = null;
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    return shapeFactory.createRectangle(
        fv.getX(),
        fv.getY(),
        secondVertice.getX(),
        secondVertice.getY(),
        Model.getSelectedColor());
  }

  @Override
  public Mshape initialMouseClick(double x, double y) {
    return null;
  }
}
