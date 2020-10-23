package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;
import com.teamjeaa.obpaint.server.ObPaintClient;

/**
 * This class is responsible for executing command by adding a Mpolyline to program. Also
 * responsible for undoing the executed action.
 *
 * <p>
 *
 * <p>Used by ToolController Uses Color, Mshape, ShapeFactory, Model
 *
 * @author Axel H
 * @since 0.3-SNAPSHOT
 */
public final class AddLine implements Command {

  private final int x1;
  private final int y1;
  private final int x2;
  private final int y2;
  private final Color color;
  private final String name;
  private final int strokeWidth;
  private Mshape line;

  /**
   * Constructor
   *
   * @param x1 Start X-value for Mpolyline
   * @param y1 Start Y-value for Mpolyline
   * @param x2 End X-value for Mpolyline
   * @param y2 End Y-Value for Mpolyline
   * @param color Color of Mpolyline
   * @param name Name of Mpolyline
   * @param strokeWidth width of Mpolyline
   */
  public AddLine(final int x1, final int y1, final int x2, final int y2, final Color color, final String name, final int strokeWidth) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.color = color;
    this.name = name;
    this.strokeWidth = strokeWidth;
  }

  /**
   * Will execute the command for creating a Mpolyline with initial values from command. It will
   * also add command to list of command and if server is connected send message to client.
   */
  @Override
  public void execute() {
    final ShapeFactory shapeFactory = new ConcreteShapeFactory();
    line = shapeFactory.createLine(x1, y1, x2, y2, color, name, strokeWidth);
    Model.INSTANCE.addToRender(line);
    Model.INSTANCE.addToCommandList(this);
    if (ObPaintClient.INSTANCE.isConnected()) {
      ObPaintClient.INSTANCE.sendLine(x1, y1, x2, y2, color, name, strokeWidth);
    }
  }

  /**
   * This method will undo the command. In this class it will remove the Mpolyline that was created
   * in previous command.
   */
  @Override
  public void undo() {
    Model.INSTANCE.removeFromRender(line);
  }
}
