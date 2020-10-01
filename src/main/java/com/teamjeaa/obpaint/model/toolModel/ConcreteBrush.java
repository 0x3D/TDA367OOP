package com.teamjeaa.obpaint.model.toolModel;

import com.teamjeaa.obpaint.model.shapeModel.Mshape;
// import javafx.scene.shape.Polyline;

/** Our Brushtool that takes care of the logic of our brush */
public class ConcreteBrush implements Tool {

  /** Constructor for our brush */
  public ConcreteBrush() {}

  @Override
  public void startUse(Double x1, Double y1) {
    // stroke.getPoints().addAll(x1, y1);
  }

  @Override
  public Mshape stopUse(Double x1, Double y1) {
    // stroke.getPoints().addAll(x1, y1);
    // Polyline strokeCopy = stroke;
    // stroke = new Polyline();
    // return strokeCopy;
    return null;
  }

  @Override
  public Mshape initialMouseClick(double x, double y) {
    // return stroke;
    return null;
  }
}
