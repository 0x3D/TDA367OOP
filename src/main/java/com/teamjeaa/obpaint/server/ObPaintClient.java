package com.teamjeaa.obpaint.server;

import com.teamjeaa.obpaint.model.Color;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public enum ObPaintClient {
  INSTANCE;

  private boolean connected = false;
  private String ip;
  private int port;

  private void sendMessage(String s){
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
      sendMessage("Circle," + radius + "," + centerX + "," + centerY + "," +
              color.toString() + "," + name);
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
}
