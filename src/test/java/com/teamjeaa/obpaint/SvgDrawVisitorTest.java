package com.teamjeaa.obpaint;

import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SvgDrawVisitorTest {

  @Test
  void visitMellipse() {

    StringBuilder sb = new StringBuilder();
    SvgDrawVisitor svgDrawVisitor = new SvgDrawVisitor(sb);
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Mshape mellipse = shapeFactory.createCircle(100, 80, 80, Color.PINK, "test");

    mellipse.acceptDrawVisitor(svgDrawVisitor);
    assertEquals(
        "<ellipse cx=\"80\" cy=\"80\" rx=\"100\" ry=\"100\" style=\"fill:rgb(255,175,175)\"/>\n",
        sb.toString());
  }

  @Test
  void visitMpolyogon() {
    StringBuilder sb = new StringBuilder();
    SvgDrawVisitor svgDrawVisitor = new SvgDrawVisitor(sb);
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Mshape mRectangle = shapeFactory.createRectangle(80, 80, 300, 300, Color.PINK, "test");
    mRectangle.acceptDrawVisitor(svgDrawVisitor);
    assertEquals(
        "<polygon points=\"80,80 300,80 300,300 80,300\" style=\"fill:rgb(255,175,175)\"/>\n",
        sb.toString());
  }

  @Test
  void visitMpolyline() {
    StringBuilder sb = new StringBuilder();
    SvgDrawVisitor svgDrawVisitor = new SvgDrawVisitor(sb);
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Mshape mRectangle = shapeFactory.createLine(0, 0, 300, 300, Color.PINK, "test");
    mRectangle.acceptDrawVisitor(svgDrawVisitor);
    assertEquals(
        "<polyline points=\"0,0 300,300\" style=\"stroke:rgb(255,175,175)\"/>\n", sb.toString());
  }
}
