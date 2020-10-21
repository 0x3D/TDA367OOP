package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.server.ObPaintClient;

/**
 * Command that executes command by moving desired object on canvas.
 *
 * Used by ToolController, ShapeInfoController
 * Uses Mshape, Model
 *
 * @author Axel H
 * @since 0.3-SNAPSHOT
 */
public final class Move implements Command {

  private final int mouseDownX;
  private final int mouseDownY;
  private final int mouseUpX;
  private final int mouseUpY;
  private Mshape shapeToMove;

  /**
   * Constructor for move command
   * @param mouseDownX X-position of shape to move
   * @param mouseDownY Y-position of shape to move
   * @param mouseUpX X-position where shape should be moved
   * @param mouseUpY Y-position where shape should be moved.
   */
  public Move(int mouseDownX, int mouseDownY, int mouseUpX, int mouseUpY) {
    this.mouseDownX = mouseDownX;
    this.mouseDownY = mouseDownY;
    this.mouseUpX = mouseUpX;
    this.mouseUpY = mouseUpY;
  }

  /**
   * Execute command by moving object at mouseDownX and mouseDownY coordinates to mouseUpX and mouseUpY
   * coordinates. Saves shape to move to be able to undo.
   */
  @Override
  public void execute() {
    try {
      shapeToMove = Model.INSTANCE.findShapeAtPoint(mouseDownX, mouseDownY);
      Model.INSTANCE.removeFromRender(shapeToMove);
      int mouseDeltaX = mouseUpX - mouseDownX;
      int mouseDeltaY = mouseUpY - mouseDownY;
      Model.INSTANCE.addToRender(shapeToMove.translate(mouseDeltaX, mouseDeltaY));
      Model.INSTANCE.addToCommandList(this);
      if (ObPaintClient.INSTANCE.isConnected()) {
        ObPaintClient.INSTANCE.sendMove(mouseDownX,mouseDownY,mouseUpX,mouseUpY);
      }
    } catch (IllegalArgumentException e) {
      System.out.println("Found no object to move");
    }
  }

  /**
   * Executes undo command by moving object back to previous location.
   */
  @Override
  public void undo() {
    shapeToMove = Model.INSTANCE.findShapeAtPoint(mouseUpX,mouseUpY);
    Model.INSTANCE.removeFromRender(shapeToMove);
    int mouseDeltaX = mouseUpX - mouseDownX;
    int mouseDeltaY = mouseUpY - mouseDownY;
    Model.INSTANCE.addToRender(shapeToMove.translate(-(mouseDeltaX),-(mouseDeltaY)));
  }
}
