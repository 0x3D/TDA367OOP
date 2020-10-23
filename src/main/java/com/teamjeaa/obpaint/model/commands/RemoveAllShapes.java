package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.server.ObPaintClient;

import java.util.ArrayList;
import java.util.List;

/**
 * RemoveAllShape command removes all the shapes on the canvas
 *
 * <p>Used by MainController Uses Mshape and Model
 *
 * @author Axel h
 * @since 0.3 SNAPSHOT
 */
public final class RemoveAllShapes implements Command {
  private List<Mshape> removedShapes;

  /**
   * executeMethod that will execute our Commands tha tare defined in the Command package,
   * "com\teamjeaa\obpaint\model\commands"
   */
  @Override
  public void execute() {
    removedShapes = new ArrayList<>(Model.INSTANCE.getCanvasShapes());
    Model.INSTANCE.addToCommandList(this);
    Model.INSTANCE.removeAllShapes();
    if (ObPaintClient.INSTANCE.isConnected()) {
      ObPaintClient.INSTANCE.sendRemoveAll();
    }
  }

  /** Undo command that revert what initially was made by the defined command. */
  @Override
  public void undo() {
    for (final Mshape mshape : removedShapes) {
      Model.INSTANCE.addToRender(mshape);
    }
  }
}
