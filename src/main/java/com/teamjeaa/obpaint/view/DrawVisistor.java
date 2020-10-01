package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.model.shapeModel.Mellipse;
import com.teamjeaa.obpaint.model.shapeModel.Mpolygon;

public interface DrawVisistor {
  void visitMellipse(Mellipse mellipse);

  void visitMpolyogon(Mpolygon mshape);
}
