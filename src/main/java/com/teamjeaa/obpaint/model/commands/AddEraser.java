package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;

public final class AddEraser implements Command {
  private final int x;
  private final int y;
  private Mshape removedShape;

  public AddEraser(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * executeMethod that will execute our Commands tha tare defined in the Command package,
   * "com\teamjeaa\obpaint\model\commands"
   */
  @Override
  public void execute() {
    removedShape = Model.INSTANCE.findShapeAtPoint(x,y);
    Model.INSTANCE.removeFromRenderByPoint(x, y);
    Model.INSTANCE.addToCommandList(this);
  }

  @Override
  public void undo() {
    Model.INSTANCE.addToRender(removedShape);
  }
}
