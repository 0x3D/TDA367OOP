package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;

public final class Move implements Command {

  private final int mouseDownX;
  private final int mouseDownY;
  private final int mouseUpX;
  private final int mouseUpY;

  public Move(int mouseDownX, int mouseDownY, int mouseUpX, int mouseUpY) {
    this.mouseDownX = mouseDownX;
    this.mouseDownY = mouseDownY;
    this.mouseUpX = mouseUpX;
    this.mouseUpY = mouseUpY;
  }

  @Override
  public void execute() {
    try {
      Mshape shapeToMove = Model.INSTANCE.findShapeAtPoint(mouseDownX, mouseDownY);
      Model.INSTANCE.removeFromRenderByPoint(mouseDownX, mouseDownY);
      int mouseDeltaX = mouseUpX - mouseDownX;
      int mouseDeltaY = mouseUpY - mouseDownY;
      Model.INSTANCE.addToRender(shapeToMove.translate(mouseDeltaX, mouseDeltaY));
    } catch (IllegalArgumentException e) {
      System.out.println("Found no object to move");
    }
  }
}
