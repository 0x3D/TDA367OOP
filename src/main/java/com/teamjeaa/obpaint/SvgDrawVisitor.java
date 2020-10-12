package com.teamjeaa.obpaint;

import com.teamjeaa.obpaint.model.shapeModel.Mellipse;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
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
    stringBuilder.append("\" style=\"fill:rgb(");
    stringBuilder
        .append(mellipse.getColor().getRed())
        .append(",")
        .append(mellipse.getColor().getGreen())
        .append(",")
        .append(mellipse.getColor().getBlue())
        .append(")");
    stringBuilder.append("\" />");
  }

  @Override
  public void visitMpolyogon(Mpolygon mshape) {
    stringBuilder.append("<polygon points=\"");
    for (Mpoint mpoint : mshape.getPoints()) {
      stringBuilder.append(mpoint.getX()).append(",").append(mpoint.getY()).append(" ");
    }
    stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
    stringBuilder.append("\" style=\"fill:rgb(");
    stringBuilder
        .append(mshape.getColor().getRed())
        .append(",")
        .append(mshape.getColor().getGreen())
        .append(",")
        .append(mshape.getColor().getBlue())
        .append(")");
    stringBuilder.append("\" />");
  }

  @Override
  public void visitMpolyline(Mpolyline mpolyline) {
    stringBuilder.append("<polyline points=\"");
    for (Mpoint mpoint : mpolyline.getPoints()) {
      stringBuilder.append(mpoint.getX()).append(",").append(mpoint.getY()).append(" ");
    }
    stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
    stringBuilder.append("\" style=\"stroke:rgb(");
    stringBuilder
        .append(mpolyline.getColor().getRed())
        .append(",")
        .append(mpolyline.getColor().getGreen())
        .append(",")
        .append(mpolyline.getColor().getBlue())
        .append(")");
    stringBuilder.append("\" />");
  }
}
