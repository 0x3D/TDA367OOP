package com.teamjeaa.obpaint.fileManager;

import com.teamjeaa.obpaint.fileManager.SvgDrawVisitor;
import com.teamjeaa.obpaint.fileManager.SvgParser;
import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;
import com.teamjeaa.obpaint.view.DrawVisitor;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SvgCommonTest {

  private List<Mshape> createShapes(){
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    List<Mshape> shapes = new ArrayList<>();
    shapes.add(shapeFactory.createCircle(10,15,15,new Color(200,100,0),"Circle"));
    shapes.add(shapeFactory.createLine(10,10,100,100,new Color(0,100,200),"Line",1));
    shapes.add(shapeFactory.createRectangle(400,400,600,600,new Color(0,200,100),"Rectangle"));
    List<Mpoint> mpoints = new ArrayList<>();
    mpoints.add(new Mpoint(1,1));
    mpoints.add(new Mpoint(15,15));
    mpoints.add(new Mpoint(300,300));
    shapes.add(shapeFactory.createPolyline(mpoints,new Color(100,200,0),"Polyline",1));
    return shapes;
  }

  @Test
  void read(){
    List<Mshape> originalShapes = createShapes();
    StringBuilder stringBuilder = new StringBuilder();
    DrawVisitor svgDrawVisitor = new SvgDrawVisitor(stringBuilder);
    stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n");
    stringBuilder.append("<svg width=\"")
            .append(800)
            .append("\" height=\"")
            .append(800)
            .append("\" xmlns=\"http://www.w3.org/2000/svg\">\n");
    for (Mshape mshape : originalShapes) {
      mshape.acceptDrawVisitor(svgDrawVisitor);
    }
    stringBuilder.append("\n").append("</svg>");
    try {
      PrintWriter writer = new PrintWriter("test.svg", StandardCharsets.UTF_8);
      writer.print(stringBuilder.toString());
      writer.flush();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    SvgParser svgParser = new SvgParser();
    File testFile = new File("test.svg");
    svgParser.openFile(testFile);
    svgParser.parseFile();
    List<Mshape> transferredShapes = svgParser.getMshapeList();
    assertEquals(originalShapes,transferredShapes);
  }
}
