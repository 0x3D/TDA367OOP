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


  private void addCircle(int radius, int centerX, int centerY, Color color, String name){
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Model.INSTANCE.addToRender(shapeFactory.createCircle(radius, centerX, centerY,color,name));

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
          handleInput(line);

        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void handleInput(String line) {
    String[] coordinates = line.split(",");
    if(line.contains("Circle")){
      parseCircle(coordinates);
    } else if(line.contains("Remove")){
      parseRemove(coordinates);
    }

    System.out.println(line);
  }

  private void parseRemove(String[] coordinates) {
    Model.INSTANCE.removeFromRenderByPoint(Integer.parseInt(coordinates[1]),
            Integer.parseInt(coordinates[2]));
  }

  private void parseCircle(String[] line) {
    addCircle(Integer.parseInt(line[1]),
            Integer.parseInt(line[2]),
            Integer.parseInt(line[3]),
            new Color(Integer.parseInt(line[4]),Integer.parseInt(line[5]),
                    Integer.parseInt(line[6]),Integer.parseInt(line[7])),
            line[8]);
  }
}
