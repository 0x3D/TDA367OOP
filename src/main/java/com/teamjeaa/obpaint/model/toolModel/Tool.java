package com.teamjeaa.obpaint.model.toolModel;

import com.teamjeaa.obpaint.model.shapeModel.Mshape;
// import javafx.scene.shape.Shape;

/** Tool interface that holds the methods that our tools will use */
public interface Tool {

  void startUse(Double x1, Double y1);

  Mshape stopUse(Double x1, Double y1);

  Mshape initialMouseClick(double x, double y);

}
