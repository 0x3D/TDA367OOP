package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.server.ObPaintClient;

public final class Eraser implements Command {
  private final int x;
  private final int y;
  private Mshape removedShape;

  public Eraser(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * executeMethod that will execute our Commands tha tare defined in the Command package,
   * "com\teamjeaa\obpaint\model\commands"
   */
  @Override
  public void execute() {
    try {
      removedShape = Model.INSTANCE.findShapeAtPoint(x,y);
      Model.INSTANCE.removeFromRenderByPoint(x, y);
      Model.INSTANCE.addToCommandList(this);
    } catch (IllegalArgumentException e){
      System.out.println("Found no object to remove");
    }
    if (ObPaintClient.INSTANCE.isConnected()) {
      ObPaintClient.INSTANCE.removeShapeAt(x,y);
    }
  }

  @Override
  public void undo() {
    Model.INSTANCE.addToRender(removedShape);
  }
}
