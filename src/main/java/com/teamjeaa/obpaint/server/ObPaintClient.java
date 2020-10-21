package com.teamjeaa.obpaint.server;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public enum ObPaintClient {
  INSTANCE;

  private boolean connected = false;
  private String ip;
  private int port;

  private void sendMessage(String s) {
    try {
      var socket = new Socket(ip, port);
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      //       out.printf("Circle: %d %d %10.8f", radius, centerX, centerY);
      connected = true;
      out.println(s);
    } catch (InterruptedIOException interruptedIOException) {
      System.err.println("Remote host timed out");
      connected = false;
    } catch (IOException e) {
      e.printStackTrace();
      connected = false;
    }
  }

  public void sendCircle(int radius, int centerX, int centerY, Color color, String name) {
    sendMessage(
        "Circle," + radius + "," + centerX + "," + centerY + "," + color.toString() + "," + name);
  }

  public void connect(String ip, int port) {
    this.ip = ip;
    this.port = port;
    this.connected = true;
  }

  public boolean isConnected() {
    return connected;
  }

  public void removeShapeAt(int x, int y) {
    sendMessage("Remove," + x + "," + y);
  }

  public void sendLine(int x1, int y1, int x2, int y2, Color color, String name, int strokeWidth) {
    sendMessage("Line," + x1 + "," + y1 + "," + x2 + "," + y2 + "," + color + "," + name + "," + strokeWidth);
  }

  public void sendRectangle(int x1, int y1, int x2, int y2, Color color, String name) {
    sendMessage("Rectangle," + x1 + "," + y1 + "," + x2 + "," + y2 + "," + color + "," + name);
  }

  public void sendMove(int originX, int originY, int destinationX, int destinationY) {
    sendMessage("Move," + originX + "," + originY + "," + destinationX + "," + destinationY);
  }

  public void sendPencilStroke(List<Mpoint> points, Color color, String name, int strokeWidth) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Pencil,").append("{,");
    for(Mpoint mpoint:points){
      stringBuilder.append(mpoint.getX()).append(",");
      stringBuilder.append(mpoint.getY()).append(",");
    }
    stringBuilder.append("},");
    stringBuilder.append(color).append(",");
    stringBuilder.append(name);
    stringBuilder.append(",").append(strokeWidth);
    sendMessage(stringBuilder.toString());

  }
}
