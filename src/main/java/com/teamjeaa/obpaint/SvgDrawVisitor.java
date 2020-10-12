package com.teamjeaa.obpaint;

import com.teamjeaa.obpaint.model.shapeModel.Mellipse;
import com.teamjeaa.obpaint.model.shapeModel.Mpolygon;
import com.teamjeaa.obpaint.model.shapeModel.Mpolyline;
import com.teamjeaa.obpaint.view.DrawVisitor;

final class SvgDrawVisitor implements DrawVisitor {
  private final StringBuilder stringBuilder;

  SvgDrawVisitor(StringBuilder stringBuilder) {
    this.stringBuilder = stringBuilder;
  }

  @Override
  public void visitMellipse(Mellipse mellipse) {
    stringBuilder.append("<ellipse cx=\"");
    stringBuilder.append(mellipse.getCenterPoint().getX());
    stringBuilder.append("\" cy=\"");
    stringBuilder.append(mellipse.getCenterPoint().getY());
    stringBuilder.append("\" rx=\"");
    stringBuilder.append(mellipse.getSemiAxesA());
    stringBuilder.append("\" ry=\"");
    stringBuilder.append(mellipse.getSemiAxesB());
    stringBuilder.append("\" style=\"fill:yellow;stroke:purple;stroke-width:2\" />");
  }

  @Override
  public void visitMpolyogon(Mpolygon mshape) {}

  @Override
  public void visitMpolyline(Mpolyline mpolyline) {}
}
