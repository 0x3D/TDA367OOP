package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.server.ObPaintClient;

public final class Move implements Command {

  private final int mouseDownX;
  private final int mouseDownY;
  private final int mouseUpX;
  private final int mouseUpY;
  private Mshape shapeToMove;

  private int newValX;
  private int newValY;



  public Move(int mouseDownX, int mouseDownY, int mouseUpX, int mouseUpY) {
    this.mouseDownX = mouseDownX;
    this.mouseDownY = mouseDownY;
    this.mouseUpX = mouseUpX;
    this.mouseUpY = mouseUpY;
  }

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

  @Override
  public void undo() {
    shapeToMove = Model.INSTANCE.findShapeAtPoint(mouseUpX,mouseUpY);
    Model.INSTANCE.removeFromRender(shapeToMove);
    int mouseDeltaX = mouseUpX - mouseDownX;
    int mouseDeltaY = mouseUpY - mouseDownY;
    Model.INSTANCE.addToRender(shapeToMove.translate(-(mouseDeltaX),-(mouseDeltaY)));
  }
}
