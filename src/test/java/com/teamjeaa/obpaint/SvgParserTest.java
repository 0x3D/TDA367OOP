package com.teamjeaa.obpaint;

import com.teamjeaa.obpaint.model.shapeModel.*;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class SvgParserTest {

  @Test
  void openFile() {
    File input = new File("input.svg");
    SvgParser svgParser = new SvgParser();
    svgParser.OpenFile(input);
  }

  @Test
  void createEllipse() {
    SvgParser svgParser = new SvgParser();
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Mshape toBeEqual = shapeFactory.createCircle(281,296,325,new Color(179,102,26));
    Mshape mshapeFromSVG = svgParser.createEllipse("<ellipse cx=\"296\" cy=\"325\" rx=\"281\" ry=\"281\" style=\"fill:rgb(179,102,26)\"/>");
    assertEquals(toBeEqual,mshapeFromSVG);
  }
}