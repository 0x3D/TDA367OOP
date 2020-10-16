package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;

import java.awt.*;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.net.Socket;

public class AddCircle implements Command {

  private final int radius;
  private final int centerX;
  private final int centerY;
  private final Color color;
  private final String name;

  public AddCircle(int radius, int centerX, int centerY, Color color, String name) {
    this.radius = radius;
    this.centerX = centerX;
    this.centerY = centerY;
    this.color = color;
    this.name = name;
  }

  @Override
  public void execute() {
    final ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Model.INSTANCE.addToRender(shapeFactory.createCircle(radius, centerX, centerY, color,name));
    try {
      var socket = new Socket("192.168.1.145", 1337);
      socket.setSoTimeout(10);
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//       out.printf("Circle: %d %d %10.8f", radius, centerX, centerY);
      out.println("" + radius +"," + centerX + "," + centerY);
    } catch (InterruptedIOException iioe){
      System.err.println("Remote host timed out");
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
