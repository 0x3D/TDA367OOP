package com.teamjeaa.obpaint.model.toolModel;

import com.teamjeaa.obpaint.model.shapeModel.Mshape;
//import javafx.scene.shape.Polyline;

/** Our Brushtool that takes care of the logic of our brush */
public class ConcreteBrush implements Tool {
  /** Size of the brush that is final. We creating a new brush everytime we change the Size */
  private final int size;

  //private Polyline stroke = new Polyline();

  /**
   * Constructor for our brush
   *
   * @param size of the brush
   */
  public ConcreteBrush(int size) {
    this.size = size;
  }


  @Override
  public void startUse(Double x1, Double y1) {
    //stroke.getPoints().addAll(x1, y1);
  }

  @Override
  public Mshape stopUse(Double x1, Double y1) {
    //stroke.getPoints().addAll(x1, y1);
    //Polyline strokeCopy = stroke;
    //stroke = new Polyline();
    // return strokeCopy;
    return null;
  }

  @Override
  public Mshape initialMouseClick(double x, double y) {
    // return stroke;
    return null;
  }


}
