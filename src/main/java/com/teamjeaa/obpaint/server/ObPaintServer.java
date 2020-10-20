package com.teamjeaa.obpaint.server;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;

import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public final class ObPaintServer implements Runnable {


  private void addCircle(int radius, int x, int y, Color color, String name){
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    shapeFactory.createCircle(radius, x, y,color,name);
  }


  @Override
  public void run() {
    Socket socket = null;
    try {
      var listener = new ServerSocket(1337);
      while(true){
        socket = listener.accept();
        Scanner in = new Scanner(socket.getInputStream());
        String line = in.nextLine();
        if (line != null) {
          String[] coordinates = line.split(",");
          addCircle(Integer.parseInt(coordinates[0]),
                  Integer.parseInt(coordinates[1]),
                  Integer.parseInt(coordinates[2]),
                  new Color(100,100,100,20),
                  "Circle");
          System.out.println(line);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
