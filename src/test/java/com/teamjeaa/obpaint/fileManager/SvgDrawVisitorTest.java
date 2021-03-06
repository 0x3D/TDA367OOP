package com.teamjeaa.obpaint.fileManager;

import com.teamjeaa.obpaint.fileManager.SvgDrawVisitor;
import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;
import com.teamjeaa.obpaint.view.DrawVisitor;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class SvgDrawVisitorTest {

  @Test
  void visitMellipse() {

    StringBuilder sb = new StringBuilder();
    DrawVisitor svgDrawVisitor = new SvgDrawVisitor(sb);
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Mshape mellipse = shapeFactory.createCircle(100, 80, 80, new Color(255, 175, 175), "test");

    mellipse.acceptDrawVisitor(svgDrawVisitor);
    assertEquals(
        "<ellipse cx=\"80\" cy=\"80\" rx=\"100\" ry=\"100\" style=\"fill:rgb(255,175,175)\"/>\n",
        sb.toString());
  }

  @Test
  void visitMpolyogon() {
    StringBuilder sb = new StringBuilder();
    DrawVisitor svgDrawVisitor = new SvgDrawVisitor(sb);
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Mshape mRectangle = shapeFactory.createRectangle(80, 80, 300, 300, new Color(255, 175, 175), "test");
    mRectangle.acceptDrawVisitor(svgDrawVisitor);
    assertEquals(
        "<polygon points=\"80,80 300,80 300,300 80,300\" style=\"fill:rgb(255,175,175)\"/>\n",
        sb.toString());
  }

  @Test
  void visitMpolyline() {
    StringBuilder sb = new StringBuilder();
    DrawVisitor svgDrawVisitor = new SvgDrawVisitor(sb);
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Mshape mRectangle = shapeFactory.createLine(0, 0, 300, 300, new Color(255, 175, 175), "test",1);
    mRectangle.acceptDrawVisitor(svgDrawVisitor);
    assertEquals(
        "<polyline points=\"0,0 300,300\" style=\"fill:none; stroke:rgb(255,175,175)\"/>\n",
        sb.toString());
  }
}
