package com.teamjeaa.obpaint.server;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

/**
 * This singleton is used to connect to another computer, see if connected and send messages
 *
 * @author Erik R
 * @since 0.2 SNAPSHOT
 */
public enum ObPaintClient {
  INSTANCE;

  private boolean connected = false;
  private int port;
  private String ip;

  private void sendMessage(final String s) {
    try {
      final var socket = new Socket(ip, port);
      final PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      connected = true;
      out.println(s);
    } catch (final InterruptedIOException interruptedIOException) {
      System.err.println("Remote host timed out");
      connected = false;
    } catch (final IOException e) {
      e.printStackTrace();
      connected = false;
    }
  }

  /**
   * Make program try to send messages to another computer
   *
   * @param ip The other computers ip-adress
   * @param port The other computers port
   */
  public void connect(final String ip, final int port) {
    this.ip = ip;
    this.port = port;
    this.connected = true;
  }

  public boolean isConnected() {
    return connected;
  }

  /**
   * Tell the other computer to remove a shape at coordinates
   *
   * @param x the x coordinate
   * @param y the y coordinate
   */
  public void removeShapeAt(final int x, final int y) {
    sendMessage("Remove," + x + "," + y);
  }

  /**
   * Tell the other computer to paint a circle
   *
   * @param radius of the circle
   * @param centerX center x position of the circle
   * @param centerY center y position of the circle
   * @param color color of the circle
   * @param name name of the circle
   */
  public void sendCircle(final int radius, final int centerX, final int centerY, final Color color, final String name) {
    sendMessage(
        "Circle," + radius + "," + centerX + "," + centerY + "," + color.toString() + "," + name);
  }

  /**
   * Tell the other computer to paint a straight line between two points
   *
   * @param x1 x-coordinate of the first point
   * @param y1 y-coordinate of the first point
   * @param x2 x-coordinate of the second point
   * @param y2 y-coordinate of the second point
   * @param color the color of the line
   * @param name the name of the line
   * @param strokeWidth the width of the line
   */
  public void sendLine(final int x1, final int y1, final int x2, final int y2, final Color color, final String name, final int strokeWidth) {
    sendMessage(
        "Line,"
            + x1
            + ","
            + y1
            + ","
            + x2
            + ","
            + y2
            + ","
            + color
            + ","
            + name
            + ","
            + strokeWidth);
  }

  /**
   * Tell the other computer to create a rectangle with the corners(x1,y1) and (x2,y2)
   *
   * @param x1 The first point x
   * @param y1 the first point y
   * @param x2 the second point x
   * @param y2 the second point y
   * @param color the color of the rectangle
   * @param name the name of the rectangle
   */
  public void sendRectangle(final int x1, final int y1, final int x2, final int y2, final Color color, final String name) {
    sendMessage("Rectangle," + x1 + "," + y1 + "," + x2 + "," + y2 + "," + color + "," + name);
  }

  /**
   * Tell the other computer to move a shape
   *
   * @param originX the x coordinate of the shape
   * @param originY the y coordinate of the shape
   * @param destinationX the destination x coordinate of the shape
   * @param destinationY the destination y coordinate of the shape
   */
  public void sendMove(final int originX, final int originY, final int destinationX, final int destinationY) {
    sendMessage("Move," + originX + "," + originY + "," + destinationX + "," + destinationY);
  }

  /**
   * Send a free form line. Paints a line between points.
   *
   * @param points the points that bind the line
   * @param color the color of the line
   * @param name the name of the line
   * @param strokeWidth the width of the line
   */
  public void sendPencilStroke(final List<Mpoint> points, final Color color, final String name, final int strokeWidth) {
    final StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Pencil,").append("{,");
    for (final Mpoint mpoint : points) {
      stringBuilder.append(mpoint.getX()).append(",");
      stringBuilder.append(mpoint.getY()).append(",");
    }
    stringBuilder.append("},");
    stringBuilder.append(color).append(",");
    stringBuilder.append(name);
    stringBuilder.append(",").append(strokeWidth);
    sendMessage(stringBuilder.toString());
  }

  /** Sending a message to reset the Canvas */
  public void sendRemoveAll() {
    sendMessage("ResetCanvas,");
  }
}
