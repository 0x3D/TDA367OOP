package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.server.ObPaintClient;

/**
 * This class is responsible for executing command by removing desired object It is also responsible
 * for undoing latest command.
 *
 * <p>
 *
 * <p>Used by ToolController, ShapeInfoController Uses Mshape, Model
 *
 * @author Erik B
 * @since 0.3-SNAPSHOT
 */
public final class Eraser implements Command {
  private final int x;
  private final int y;
  private Mshape removedShape;

  /**
   * Constructor for the command Eraser
   *
   * @param x x location of the object that will be removed from canvas
   * @param y y location of the object that will be removed from canvas
   */
  public Eraser(final int x, final int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Executes command by searching for object on x & y values. If shape is found in list then it
   * saves reference to object and removes it for list. Reference i later used for undo. If server
   * is connected it sends message to client to delete object.
   */
  @Override
  public void execute() {
    try {
      removedShape = Model.INSTANCE.findShapeAtPoint(x, y);
      Model.INSTANCE.removeFromRenderByPoint(x, y);
      Model.INSTANCE.addToCommandList(this);
    } catch (final IllegalArgumentException e) {
      System.out.println("Found no object to remove");
    }
    if (ObPaintClient.INSTANCE.isConnected()) {
      ObPaintClient.INSTANCE.removeShapeAt(x, y);
    }
  }

  /** Executes undo command by adding the removed shape to model again. */
  @Override
  public void undo() {
    Model.INSTANCE.addToRender(removedShape);
  }
}
