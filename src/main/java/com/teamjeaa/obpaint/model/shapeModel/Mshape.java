package com.teamjeaa.obpaint.model.shapeModel;

public interface Mshape {
  Mpoint getPosition();
  int getWidth();
  int getHeight();
  
  
  /**
   * 
   * @param x - int new x pos
   * @param y - int new y pos
   * @return New translated Mshape
   */
  Mshape translate(int x, int y);
}
