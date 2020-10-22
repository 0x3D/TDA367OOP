package com.teamjeaa.obpaint.fileManager;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Class to read a svg file and generate a list of MShapes from the file
 * @author Erik R
 * @since 0.2-SNAPSHOT
 */
public final class SvgParser {
  private final List<String> fileInStrings = new ArrayList<>();
  private final List<Mshape> mshapeList = new ArrayList<>();

  /** Get generated shapes
   * @return shapes that are generated */
  public List<Mshape> getMshapeList() {
    return mshapeList;
  }

  /** Open a file to ready class to read
   * @param input file to read */
  public void openFile(File input) {
    try {
      Scanner reader = new Scanner(input);
      while (reader.hasNextLine()) {
        String data = reader.nextLine();
        fileInStrings.add(data);
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
      e.printStackTrace();
    }
  }

  /** Go through file and generate all shapes
   * */
  public void parseFile() {
    if (fileInStrings.isEmpty()) {
      throw new IllegalStateException("File not read no data to operate on");
    }
    for (String line : fileInStrings) {
      if (line.contains("ellipse")) {
        mshapeList.add(createEllipse(line));
      } else if (line.contains("polygon")) {
        mshapeList.add(createPolygon(line));
      } else if (line.contains("polyline")) {
        mshapeList.add(createPolyline(line));
      }
    }
  }

  Mshape createPolyline(String line) {
    List<String> tokens = Arrays.asList(line.split("="));
    List<Mpoint> mpoints = new ArrayList<>();
    Color color = new Color(255, 255, 255);
    for (String token : tokens) {
      if (token.contains("points")) {
        extractPoints(tokens, mpoints, token);
      } else if (token.contains("rgb")) {
        color = extractColor(token);
      }
    }
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    // TODO: make this create an polygon if more than 4 points
    // TODO: Read stroke if exists
    return shapeFactory.createPolyline(mpoints, color, "Rectangle", 1);
  }

  // "<polygon points=\"80,80 300,80 300,300 80,300\" style=\"fill:rgb(255,175,175)\"/>\n");
  Mshape createPolygon(String line) {
    List<String> tokens = Arrays.asList(line.split("="));
    List<Mpoint> mpoints = new ArrayList<>();
    Color color = new Color(255, 255, 255);
    for (String token : tokens) {
      if (token.contains("points")) {
        extractPoints(tokens, mpoints, token);
      } else if (token.contains("rgb")) {
        color = extractColor(token);
      }
    }
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    // TODO: make this create an polygon if more than 4 points
    return shapeFactory.createRectangle(
        mpoints.get(0).getX(),
        mpoints.get(0).getY(),
        mpoints.get(2).getX(),
        mpoints.get(2).getY(),
        color,
        "Rectangle");
  }

  private void extractPoints(List<String> tokens, List<Mpoint> mpoints, String token) {
    String[] points = tokens.get(tokens.indexOf(token) + 1).split(",|\\s");
    for (int i = 0; i < points.length - 2; i = i + 2) {
      int x = extractNumber(points[i]);
      int y = extractNumber(points[i + 1]);
      mpoints.add(new Mpoint(x, y));
    }
  }

  Mshape createEllipse(String line) {
    List<String> tokens = Arrays.asList(line.split("="));
    int xPos = 0;
    int yPos = 0;
    int rx = 0;
    int ry = 0;
    Color color = new Color(255, 255, 255);
    for (String token : tokens) {
      if (token.contains("cx")) {
        xPos = extractNumber(tokens.get(tokens.indexOf(token) + 1));
      } else if (token.contains("cy")) {
        yPos = extractNumber(tokens.get(tokens.indexOf(token) + 1));
      } else if (token.contains("rx")) {
        rx = extractNumber(tokens.get(tokens.indexOf(token) + 1));
      } else if (token.contains("ry")) {
        ry = extractNumber(tokens.get(tokens.indexOf(token) + 1));
      } else if (token.contains("rgb")) {
        color = extractColor(token);
      }
    }
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    // TODO: make this create an ellipse instead of circle
    return shapeFactory.createCircle(rx, xPos, yPos, color, "Circle");
  }

  private Color extractColor(String token) {
    String[] strings = token.split(",");
    final int r = extractNumber(strings[0]);
    final int g = extractNumber(strings[1]);
    final int b = extractNumber(strings[2]);
    return new Color(r, g, b);
  }

  private int extractNumber(String toReplaceIn) {
    return Integer.parseInt(toReplaceIn.replaceAll("([^\\d]|[A-Z]|[\"])", ""));
  }
}
