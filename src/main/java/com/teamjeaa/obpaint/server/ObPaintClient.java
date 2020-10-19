package com.teamjeaa.obpaint.server;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public enum ObPaintClient {
  INSTANCE;

  private static PrintWriter out;
  private static Socket socket;
  private boolean connected = false;
  private String ip;
  private int port;

  public void sendCircle(int radius, int centerX, int centerY) {
    try {
      socket = new Socket(ip, port);
      out = new PrintWriter(socket.getOutputStream(), true);
      //       out.printf("Circle: %d %d %10.8f", radius, centerX, centerY);
      connected = true;
      out.println("" + radius + "," + centerX + "," + centerY);
    } catch (InterruptedIOException interruptedIOException) {
      System.err.println("Remote host timed out");
      connected = false;
    } catch (IOException e) {
      e.printStackTrace();
      connected = false;
    }
  }

  public void connect(String ip, int port) {
    this.ip = ip;
    this.port = port;
    this.connected = true;
  }

  public boolean isConnected() {
    return connected;
  }
}
