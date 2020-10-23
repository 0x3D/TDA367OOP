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
 *
 * @author Erik R
 * @since 0.2-SNAPSHOT
 */
public final class SvgParser {
  private final List<String> fileInStrings = new ArrayList<>();
  private final List<Mshape> mshapeList = new ArrayList<>();

  /**
   * Get generated shapes
   *
   * @return shapes that are generated
   */
  public List<Mshape> getMshapeList() {
    return mshapeList;
  }

  /**
   * Open a file to ready class to read
   *
   * @param input file to read
   */
  public void openFile(final File input) {
    try {
      final Scanner reader = new Scanner(input);
      while (reader.hasNextLine()) {
        final String data = reader.nextLine();
        fileInStrings.add(data);
      }
    } catch (final FileNotFoundException e) {
      System.out.println("File not found");
      e.printStackTrace();
    }
  }

  /** Go through file and generate all shapes */
  public void parseFile() {
    if (fileInStrings.isEmpty()) {
      throw new IllegalStateException("File not read no data to operate on");
    }
    for (final String line : fileInStrings) {
      if (line.contains("ellipse")) {
        mshapeList.add(createEllipse(line));
      } else if (line.contains("polygon")) {
        mshapeList.add(createPolygon(line));
      } else if (line.contains("polyline")) {
        mshapeList.add(createPolyline(line));
      }
    }
  }

  Mshape createPolyline(final String line) {
    final List<String> tokens = Arrays.asList(line.split("=")); // TODO: This and createPolygon() refactor
    final List<Mpoint> mpoints = new ArrayList<>();
    Color color = new Color(255, 255, 255);
    for (final String token : tokens) {
      if (token.contains("points")) {
        extractPoints(tokens, mpoints, token);
      } else if (token.contains("rgb")) {
        color = extractColor(token);
      }
    }
    final ShapeFactory shapeFactory = new ConcreteShapeFactory();
    // TODO: make this create an polygon if more than 4 points
    // TODO: Read stroke if exists
    return shapeFactory.createPolyline(mpoints, color, "Rectangle", 1);
  }

  // "<polygon points=\"80,80 300,80 300,300 80,300\" style=\"fill:rgb(255,175,175)\"/>\n");
  Mshape createPolygon(final String line) {
    final List<String> tokens = Arrays.asList(line.split("="));
    final List<Mpoint> mpoints = new ArrayList<>();
    Color color = new Color(255, 255, 255);
    for (final String token : tokens) {
      if (token.contains("points")) {
        extractPoints(tokens, mpoints, token);
      } else if (token.contains("rgb")) {
        color = extractColor(token);
      }
    }
    final ShapeFactory shapeFactory = new ConcreteShapeFactory();
    // TODO: make this create an polygon if more than 4 points
    return shapeFactory.createRectangle(
        mpoints.get(0).getX(),
        mpoints.get(0).getY(),
        mpoints.get(2).getX(),
        mpoints.get(2).getY(),
        color,
        "Rectangle");
  }

  private void extractPoints(final List<String> tokens, final List<Mpoint> mpoints, final String token) {
    final String[] points = tokens.get(tokens.indexOf(token) + 1).split(",|\\s");
    for (int i = 0; i < points.length - 2; i = i + 2) {
      final int x = extractNumber(points[i]);
      final int y = extractNumber(points[i + 1]);
      mpoints.add(new Mpoint(x, y));
    }
  }

  Mshape createEllipse(final String line) {
    final List<String> tokens = Arrays.asList(line.split("="));
    int xPos = 0;
    int yPos = 0;
    int rx = 0;
    int ry = 0;
    Color color = new Color(255, 255, 255);
    for (final String token : tokens) {
      if (token.contains("cx")) {
        xPos = extractNumber(tokens.get(tokens.indexOf(token) + 1));
      } else if (token.contains("cy")) {
        yPos = extractNumber(tokens.get(tokens.indexOf(token) + 1));
      } else if (token.contains("rx")) {
        rx = extractNumber(tokens.get(tokens.indexOf(token) + 1));
      } else if (token.contains("ry")) {
        // Supposed to be used in an ellipse since it has 2 different half-axes
        ry = extractNumber(tokens.get(tokens.indexOf(token) + 1));
      } else if (token.contains("rgb")) {
        color = extractColor(token);
      }
    }
    final ShapeFactory shapeFactory = new ConcreteShapeFactory();
    // TODO: make this create an ellipse instead of circle
    return shapeFactory.createCircle(rx, xPos, yPos, color, "Circle");
  }

  private Color extractColor(final String token) {
    final String[] strings = token.split(",");
    final int r = extractNumber(strings[0]);
    final int g = extractNumber(strings[1]);
    final int b = extractNumber(strings[2]);
    return new Color(r, g, b);
  }

  private int extractNumber(final String toReplaceIn) {
    return Integer.parseInt(toReplaceIn.replaceAll("([^\\d]|[A-Z]|[\"])", ""));
  }
}
