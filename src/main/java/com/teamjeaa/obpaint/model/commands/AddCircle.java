package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;

import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class AddCircle implements Command {

  private final int radius;
  private final int centerX;
  private final int centerY;
  private final Color color;

  public AddCircle(int radius, int centerX, int centerY, Color color) {
    this.radius = radius;
    this.centerX = centerX;
    this.centerY = centerY;
    this.color = color;
  }

  @Override
  public void execute() {
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Model.INSTANCE.addToRender(shapeFactory.createCircle(radius, centerX, centerY, color));
    try {
      var socket = new Socket("localhost", 1337);
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      out.println("" + radius +"," + centerX + "," + centerY);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
