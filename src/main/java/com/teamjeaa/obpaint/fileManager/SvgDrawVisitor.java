package com.teamjeaa.obpaint.fileManager;

import com.teamjeaa.obpaint.model.shapeModel.*;
import com.teamjeaa.obpaint.view.DrawVisitor;

/**
 * Class that implements the DrawVisitor using SVG Creates svg representation of shape using Visitor
 * pattern
 * @author Erik R
 * @since 0.2-SNAPSHOT
 */
public final class SvgDrawVisitor implements DrawVisitor {
  private final StringBuilder stringBuilder;

  /** Constructor for the class
   *  @param stringBuilder to add text lines to */
  public SvgDrawVisitor(StringBuilder stringBuilder) {
    this.stringBuilder = stringBuilder;
  }

  /** Create a svg line to represent a ellipse
   *  @param mellipse ellipse to create text from */
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
    addMshapeColor(mellipse);
    stringBuilder.append("\"/>\n");
  }


  private void addMshapeColor(Mshape mshape) {
    stringBuilder
        .append(mshape.getColor().getRed())
        .append(",")
        .append(mshape.getColor().getGreen())
        .append(",")
        .append(mshape.getColor().getBlue())
        .append(")");
  }

  /** Create a svg line to represent a polygon
   *  @param mpolygon Polygon to create svg text from */
  @Override
  public void visitMpolyogon(Mpolygon mpolygon) {
    stringBuilder.append("<polygon points=\"");
    for (Mpoint mpoint : mpolygon.getPoints()) {
      stringBuilder.append(mpoint.getX()).append(",").append(mpoint.getY()).append(" ");
    }
    stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
    stringBuilder.append("\" style=\"fill:rgb(");
    addMshapeColor(mpolygon);
    stringBuilder.append("\"/>\n");
  }

  /** Create a svg line to represent a polyline
   *  @param mpolyline Polyline to create svg text from */
  @Override
  public void visitMpolyline(Mpolyline mpolyline) {
    stringBuilder.append("<polyline points=\"");
    for (Mpoint mpoint : mpolyline.getPoints()) {
      stringBuilder.append(mpoint.getX()).append(",").append(mpoint.getY()).append(" ");
    }
    stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
    stringBuilder.append("\" style=\"fill:none; stroke:rgb(");
    addMshapeColor(mpolyline);
    stringBuilder.append("\"/>\n");
  }
}
