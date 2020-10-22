package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;
import com.teamjeaa.obpaint.server.ObPaintClient;


/**
 * This class is responsible for executing command by adding a Mellipse to program.
 * It is also responsible for undoing latest command.
 * <p>
 * <p>
 * Used by ToolController
 * Uses Color, Mshape, ShapeFactory, Model
 *
 * @author Axel H.
 * @since 0.3-SNAPSHOT
 */
public final class AddCircle implements Command {

  private final int radius;
  private final int centerX;
  private final int centerY;
  private final Color color;
  private final String name;
  private Mshape circle;

  /**
   * Constructor for creating a addCircle command.
   *
   * @param radius  radius for the circle
   * @param centerX center point X-value
   * @param centerY center point Y-value
   * @param color   color of circle
   * @param name    name of circle
   */
  public AddCircle(int radius, int centerX, int centerY, Color color, String name) {
    this.radius = radius;
    this.centerX = centerX;
    this.centerY = centerY;
    this.color = color;
    this.name = name;
  }

  /**
   * execute uses values from command and is responsible for creating Mellipse and adding it to render.
   * It also adds command to stack of commands to be able to perform undo(). Checks if server is connected,
   * if it is then sends message to client.
   */
  @Override
  public void execute() {
    final ShapeFactory shapeFactory = new ConcreteShapeFactory();
    circle = shapeFactory.createCircle(radius, centerX, centerY, color, name);
    Model.INSTANCE.addToRender(circle);
    Model.INSTANCE.addToCommandList(this);
    if (ObPaintClient.INSTANCE.isConnected()) {
      ObPaintClient.INSTANCE.sendCircle(radius, centerX, centerY, color, name);
    }
  }

  /**
   * Undo the current command which in this case is removing previously added Mellipse.
   */

  @Override
  public void undo() {
    Model.INSTANCE.removeFromRender(circle);
  }
}
