package com.teamjeaa.obpaint.model.toolModel;

import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;

public class ConcreteRectangleTool implements Tool {
  Mpoint firstVertice;
  Mpoint secondVertice;
  @Override
  public void initialize() {

  }

  @Override
  public void startUse(Double x1, Double y1) {
    firstVertice = new Mpoint(x1.intValue(),y1.intValue());
  }

  @Override
  public Mshape stopUse(Double x, Double y) {
    secondVertice = new Mpoint(x.intValue(),y.intValue());
    Mpoint fv = firstVertice.clone();
    Mpoint sv = secondVertice.clone();
    firstVertice = null;
    secondVertice = null;
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Mshape rect = shapeFactory.createRectangle(fv.getX(),fv.getY(), sv.getX(),sv.getY());
    return rect;
  }

  @Override
  public Mshape initialMouseClick(double x, double y) {
    return null;
  }

  @Override
  public int getSize() {
    return 0;
  }
}
