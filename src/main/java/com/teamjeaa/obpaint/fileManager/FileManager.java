package com.teamjeaa.obpaint.fileManager;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.view.DrawVisitor;

/**
 * FileManager is the class that takes care about loading svg-file in to obPaint
 *
 * @author Axel H
 */
public class FileManager {
  public static String createSvg() {
    StringBuilder sb = new StringBuilder();
    DrawVisitor drawVisitor = new SvgDrawVisitor(sb);
    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n");
    sb.append("<svg width=\"")
            .append(800)
            .append("\" height=\"")
            .append(800)
            .append("\" xmlns=\"http://www.w3.org/2000/svg\">\n");
    for (Mshape mshape : Model.INSTANCE.getCanvasShapes()) {
      mshape.acceptDrawVisitor(drawVisitor);
    }
    sb.append("\n").append("</svg>");
    return sb.toString();
  }
}
