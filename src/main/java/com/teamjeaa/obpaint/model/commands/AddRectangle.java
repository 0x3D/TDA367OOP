package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;
import com.teamjeaa.obpaint.server.ObPaintClient;

/**
 * This class is responsible for executing command by adding a Mpolygon to program.
 *  Also responsible for undoing the executed action.
 *
 *
 * Used by ToolController
 * Uses Color, Mshape, ShapeFactory, Model
 *
 * @author Axel H
 * @since 0.3-SNAPSHOT
 */
public final class AddRectangle implements Command {

  private final int x1;
  private final int y1;
  private final int x2;
  private final int y2;
  private final Color color;
  private final String name;
  private Mshape rectangle;

  /**
   * Constructor for command addRectangle.
   * @param x1 First corner X-value for Mpolygon
   * @param y1 First corner Y-value for Mpolygon
   * @param x2 Second corner X-value for Mpolygon
   * @param y2 Second corner Y-value for Mpolygon
   * @param color Color of Mpolygon
   * @param name Name of Mpolygon
   */
  public AddRectangle(int x1, int y1, int x2, int y2, Color color, String name) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.color = color;
    this.name = name;
  }

  /**
   * Will execute the command for creating a Mpolygon with initial values from command.
   * It will also add command to list of command and if server is connected send message to client.
   */
  @Override
  public void execute() {
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    rectangle = shapeFactory.createRectangle(x1, y1, x2, y2, color, name);
    Model.INSTANCE.addToRender(rectangle);
    Model.INSTANCE.addToCommandList(this);
    if (ObPaintClient.INSTANCE.isConnected()) {
      ObPaintClient.INSTANCE.sendRectangle(x1,y1,x2,y2,color,name);
    }
  }
  /**
   * This method will undo the command. In this class it will remove the Mpolygon that
   * was created in previous command.
   */
  @Override
  public void undo() {
    Model.INSTANCE.removeFromRender(rectangle);
  }
}
