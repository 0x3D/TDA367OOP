package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.ModelCanvas;

public class AddEraser implements Command {
  private final int x;
  private final int y;
  private final ModelCanvas modelCanvas;

  public AddEraser(int x, int y, ModelCanvas modelCanvas) {
    this.x = x;
    this.y = y;
    this.modelCanvas = modelCanvas;
  }

  /**
   * executeMethod that will execute our Commands tha tare defined in the Command package,
   * "com\teamjeaa\obpaint\model\commands"
   */
  @Override
  public void execute() {
    modelCanvas.removeFromRender(Model.INSTANCE.returnShapeToRemove(x, y));
  }
}
