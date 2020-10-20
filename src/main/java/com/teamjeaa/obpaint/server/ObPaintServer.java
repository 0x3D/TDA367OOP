package com.teamjeaa.obpaint.server;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;

import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class ObPaintServer implements Runnable {

  private void addCircle(int radius, int centerX, int centerY, Color color, String name) {
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Model.INSTANCE.addToRender(shapeFactory.createCircle(radius, centerX, centerY, color, name));
  }

  @Override
  public void run() {
    Socket socket = null;
    try {
      var listener = new ServerSocket(1337);
      while (true) {
        socket = listener.accept();
        Scanner in = new Scanner(socket.getInputStream());
        String line = in.nextLine();
        if (line != null) {
          handleInput(line);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void handleInput(String line) {
    String[] coordinates = line.split(",");
    if (line.contains("Circle")) {
      parseCircle(coordinates);
    } else if (line.contains("Remove")) {
      parseRemove(coordinates);
    } else if (line.contains("Line")) {
      parseLine(coordinates);
    } else if (line.contains("Rectangle")) {
      parseRectangle(coordinates);
    } else if (line.contains("Move")) {
      parseMove(coordinates);
    } else if (line.contains("Pencil")) {
      parsePencil(coordinates);
    }

    System.out.println(line);
  }

  private void parsePencil(String[] coordinates) {
    final List<Mpoint> mPoints = new ArrayList<>();
    int i = 2;

    while (!coordinates[i + 2].contains("}")) {
      mPoints.add(
          new Mpoint(Integer.parseInt(coordinates[i]), Integer.parseInt(coordinates[i + 1])));
      i = i + 2;
    }
    if (coordinates[i + 2].contains("}")) {
      coordinates[i + 1] = coordinates[i + 1].replaceAll("([^\\d]|[A-Z]|[\"])", "");
      mPoints.add(
          new Mpoint(Integer.parseInt(coordinates[i]), Integer.parseInt(coordinates[i + 1])));
      i = i + 2;
    }
    final ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Model.INSTANCE.addToRender(
        shapeFactory.createPolyline(
            mPoints,
            new Color(
                Integer.parseInt(coordinates[i+1]),
                Integer.parseInt(coordinates[i + 2]),
                Integer.parseInt(coordinates[i + 3]),
                Integer.parseInt(coordinates[i + 4])),
            coordinates[i + 5]));
  }

  private void parseMove(String[] coordinates) {
    Mshape shapeToMove =
        Model.INSTANCE.findShapeAtPoint(
            Integer.parseInt(coordinates[1]), Integer.parseInt(coordinates[2]));
    Model.INSTANCE.removeFromRenderByPoint(
        Integer.parseInt(coordinates[1]), Integer.parseInt(coordinates[2]));
    final int deltaX = Integer.parseInt(coordinates[3]) - Integer.parseInt(coordinates[1]);
    final int deltaY = Integer.parseInt(coordinates[4]) - Integer.parseInt(coordinates[2]);
    Model.INSTANCE.addToRender(shapeToMove.translate(deltaX, deltaY));
  }

  private void parseRectangle(String[] coordinates) {
    final ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Model.INSTANCE.addToRender(
        shapeFactory.createRectangle(
            Integer.parseInt(coordinates[1]),
            Integer.parseInt(coordinates[2]),
            Integer.parseInt(coordinates[3]),
            Integer.parseInt(coordinates[4]),
            new Color(
                Integer.parseInt(coordinates[5]),
                Integer.parseInt(coordinates[6]),
                Integer.parseInt(coordinates[7]),
                Integer.parseInt(coordinates[8])),
            coordinates[9]));
  }

  private void parseLine(String[] coordinates) {
    final ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Model.INSTANCE.addToRender(
        shapeFactory.createLine(
            Integer.parseInt(coordinates[1]),
            Integer.parseInt(coordinates[2]),
            Integer.parseInt(coordinates[3]),
            Integer.parseInt(coordinates[4]),
            new Color(
                Integer.parseInt(coordinates[5]),
                Integer.parseInt(coordinates[6]),
                Integer.parseInt(coordinates[7]),
                Integer.parseInt(coordinates[8])),
            coordinates[9]));
  }

  private void parseRemove(String[] coordinates) {
    Model.INSTANCE.removeFromRenderByPoint(
        Integer.parseInt(coordinates[1]), Integer.parseInt(coordinates[2]));
  }

  private void parseCircle(String[] line) {
    addCircle(
        Integer.parseInt(line[1]),
        Integer.parseInt(line[2]),
        Integer.parseInt(line[3]),
        new Color(
            Integer.parseInt(line[4]),
            Integer.parseInt(line[5]),
            Integer.parseInt(line[6]),
            Integer.parseInt(line[7])),
        line[8]);
  }
}
