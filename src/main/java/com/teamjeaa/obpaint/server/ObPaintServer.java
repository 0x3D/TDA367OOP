package com.teamjeaa.obpaint.server;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Server code. Receiver of all messages from other computers
 *
 * @author Erik R
 * @since 0.2 SNAPSHOT
 */
public final class ObPaintServer implements Runnable {
  private final int port;

  public ObPaintServer(final String port) {
    this.port = Integer.parseInt(port);
  }

  /** This is the main code of the server. */
  @Override
  public void run() {
    Socket socket;
    try {
      final var listener = new ServerSocket(port);
      // Will not quit until program does
      while (true) {
        socket = listener.accept();
        final Scanner in = new Scanner(socket.getInputStream());
        final String line = in.nextLine();
        if (line != null) {
          handleInput(line);
        }
      }
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  private void addCircle(final int radius, final int centerX, final int centerY, final Color color, final String name) {
    final ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Model.INSTANCE.addToRender(shapeFactory.createCircle(radius, centerX, centerY, color, name));
  }

  private void handleInput(final String line) {
    final String[] coordinates = line.split(",");
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
    } else if (line.contains("ResetCanvas")) parseRemoveAll();
    System.out.println(line);
  }

  private void parsePencil(final String[] coordinates) {
    final List<Mpoint> mPoints = new ArrayList<>();
    // First tokens are Pencil and {
    int i = 2;

    // Add all points to our new list
    while (!coordinates[i + 2].contains("}")) {
      mPoints.add(
          new Mpoint(Integer.parseInt(coordinates[i]), Integer.parseInt(coordinates[i + 1])));
      i = i + 2;
    }
    // If this token is found at plus 2 we have one more
    if (coordinates[i + 2].contains("}")) {
      coordinates[i + 1] = coordinates[i + 1].replaceAll("([^\\d]|[A-Z]|[\"])", "");
      mPoints.add(
          new Mpoint(Integer.parseInt(coordinates[i]), Integer.parseInt(coordinates[i + 1])));
      i = i + 2;
    }

    // add newly created shape
    final ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Model.INSTANCE.addToRender(
        shapeFactory.createPolyline(
            mPoints,
            new Color(
                Integer.parseInt(coordinates[i + 1]),
                Integer.parseInt(coordinates[i + 2]),
                Integer.parseInt(coordinates[i + 3]),
                Integer.parseInt(coordinates[i + 4])),
            coordinates[i + 5],
            Integer.parseInt(coordinates[i + 6])));
  }

  private void parseMove(final String[] coordinates) {
    final Mshape shapeToMove =
        Model.INSTANCE.findShapeAtPoint(
            Integer.parseInt(coordinates[1]), Integer.parseInt(coordinates[2]));
    Model.INSTANCE.removeFromRenderByPoint(
        Integer.parseInt(coordinates[1]), Integer.parseInt(coordinates[2]));
    final int deltaX = Integer.parseInt(coordinates[3]) - Integer.parseInt(coordinates[1]);
    final int deltaY = Integer.parseInt(coordinates[4]) - Integer.parseInt(coordinates[2]);
    Model.INSTANCE.addToRender(shapeToMove.translate(deltaX, deltaY));
  }

  private void parseRectangle(final String[] coordinates) {
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

  private void parseLine(final String[] coordinates) {
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
            coordinates[9],
            Integer.parseInt(coordinates[10])));
  }

  private void parseRemove(final String[] coordinates) {
    Model.INSTANCE.removeFromRenderByPoint(
        Integer.parseInt(coordinates[1]), Integer.parseInt(coordinates[2]));
  }

  private void parseCircle(final String[] line) {
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

  /** removes everything from the canvas */
  private void parseRemoveAll() {
    Model.INSTANCE.removeAllShapes();
  }
}
