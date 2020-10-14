package com.teamjeaa.obpaint;

import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SvgParser {
  private final List<String> fileInStrings = new ArrayList<>();
  private final List<Mshape> mshapeList = new ArrayList<>();

  private List<Mshape> getMshapeList() {
    return mshapeList;
  }

  void OpenFile(File input) {
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

  void parseFile() {
    if (fileInStrings.isEmpty()) {
      throw new IllegalStateException("File not read no data to operate on");
    }

    for (String line : fileInStrings) {
      if (line.contains("ellipse")) {
        mshapeList.add(createEllipse(line));
      } else if (line.contains("polygon")) {
        // TODO: Implement polygon creation
      } else if (line.contains("polyline")) {
        // TODO: Implement Polyline creation
      }
    }
  }

  Mshape createEllipse(String line) {
    List<String> tokens = Arrays.asList(line.split("="));
    int xPos = 0;
    int yPos = 0;
    int rx = 0;
    int ry = 0;
    int r = 0;
    int g = 0;
    int b = 0;
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
        String[] strings = token.split(",");
        r = extractNumber(strings[0]);
        g = extractNumber(strings[1]);
        b = extractNumber(strings[2]);
      }
    }
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    // TODO: make this create an ellipse instead of circle
    return shapeFactory.createCircle(rx, xPos, yPos, new Color(r, g, b));
  }

  private int extractNumber(String toReplaceIn) {
    return Integer.parseInt(toReplaceIn.replaceAll("([^\\d]|[A-Z]|[\"])", ""));
  }
}
