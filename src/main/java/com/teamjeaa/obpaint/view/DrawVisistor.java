package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.model.shapeModel.Mellipse;
import com.teamjeaa.obpaint.model.shapeModel.Mpolygon;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import javafx.scene.shape.Shape;

public interface DrawVisistor {
  void visitMellipse(Mellipse mellipse);
  void visitMpolyogon(Mpolygon mshape);
}
