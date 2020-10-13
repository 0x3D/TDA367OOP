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
import java.util.regex.Pattern;

public class SvgParser {
  private List<String> fileInStrings = new ArrayList<>();
  private List<Mshape> mshapeList = new ArrayList<>();

  void OpenFile(File input){
    try {
      Scanner reader = new Scanner(input);
      while(reader.hasNextLine()){
        String data = reader.nextLine();
        fileInStrings.add(data);
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
      e.printStackTrace();
    }
  }

  void parseFile(){
    if(fileInStrings.isEmpty()){
      throw new IllegalStateException("File not read no data to operate on");
    }

    for(String line:fileInStrings){
      if(line.contains("ellipse")){
        createEllipse(line);
      } else if(line.contains("polygon")){

      } else if(line.contains("polyline")){

      }
    }

  }

  Mshape createEllipse(String line) {
    List<String> tokens = Arrays.asList(line.split("="));
    int xPos=0;
    int yPos=0;
    int rx=0;
    int ry=0;
    int rgb=0;
    for (String token:tokens) {
      if (token.contains("cx")) {
        xPos=extractNumber(tokens.get(tokens.indexOf(token) + 1));
        }else if (token.contains("cy")) {
        yPos=extractNumber(tokens.get(tokens.indexOf(token)+1));
      } else if(token.contains("rx")){
        rx=extractNumber(tokens.get(tokens.indexOf(token)+1));
      } else if(token.contains("ry")){
        ry=extractNumber(tokens.get(tokens.indexOf(token)+1));
      } else if(token.contains("rgb")){
        rgb=extractNumber(tokens.get(tokens.indexOf(token)));
      }
    }
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    return shapeFactory.createCircle(rx,xPos,yPos,new Color(rgb));
  }

  private int extractNumber(String toReplaceIn){
    return Integer.parseInt(toReplaceIn.replaceAll("([^\\d]|[A-Z]|[\"])", ""));
  }
}
