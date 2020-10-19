package com.teamjeaa.obpaint.server;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.net.Socket;

public enum ObPaintClient {
  INSTANCE;

  private PrintWriter out;
  private boolean connected=false;

  public void sendCircle(int radius,int centerX,int centerY){
    out.println("" + radius + "," + centerX + "," + centerY);
  }


  public void connect(String ip, int port) {
    try {
      var socket = new Socket(ip, port);
      out = new PrintWriter(socket.getOutputStream(), true);
      //       out.printf("Circle: %d %d %10.8f", radius, centerX, centerY);
      connected=true;
    } catch (InterruptedIOException interruptedIOException) {
      System.err.println("Remote host timed out");
      connected=false;
    } catch (IOException e) {
      e.printStackTrace();
      connected=false;
    }
  }

  public boolean isConnected() {
    return connected;
  }
}
