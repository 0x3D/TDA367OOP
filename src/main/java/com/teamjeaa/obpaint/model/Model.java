package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.Start;
import com.teamjeaa.obpaint.controller.CanvasController;
import com.teamjeaa.obpaint.controller.ToolController;
import com.teamjeaa.obpaint.model.commands.Command;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;


import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * Responsibility Offers the most vital parts of the model without exposing. Creates ModelCanvas and
 * holds List with Observers <br>
 * Used by Start, CanvasController , ConcreteCircleTool, ConcreteRectangleTool, ToolController Uses
 * Color, List, Observer, Tool
 *
 * @author Jonas N
 * @see CanvasController
 * @see Start
 * @see ToolController
 * @see List
 * @since 0.1-SNAPSHOT
 */
public enum Model {
  INSTANCE;

  private final ModelCanvas modelCanvas;

  public final Stack<Command> commandList;

  Model() {
    modelCanvas = new ModelCanvas();
    commandList = new Stack<>();
  }

  public Mshape findShapeAtPoint(int x, int y) {
    return modelCanvas.findShapeAt(x, y);
  }

  /**
   * Adds received instance of Mshape to ModelCanvas list for render.
   *
   * @param s some kind of Mshape.
   */
  public void addToRender(Mshape s) {
    modelCanvas.addToRender(s);
  }

  public void addToCommandList(Command command){
    this.commandList.push(command);
  }

  public void undo(){
    try {
      commandList.pop().undo();
    } catch (EmptyStackException e) {
      System.out.println("Found no Command to undo");
    }
  }

  public void removeFromRenderByPoint(int x, int y) {
    try {
      modelCanvas.removeFromRender(modelCanvas.findShapeAt(x, y));
    } catch (IllegalArgumentException e) {
      System.out.println("Found no Shape to Remove");
    }
  }
  public void removeFromRender (Mshape mshape) {
    try {
      modelCanvas.removeFromRender(mshape);
    } catch (IllegalArgumentException e) {
      System.out.println("Found no Shape to Remove");
    }
  }

  /** @return Returns the list of Mshapes collected from modelCanvas. */
  public List<Mshape> getCanvasShapes() {
    return modelCanvas.getShapes();
  }
  public void removeAllShapes () {
    modelCanvas.resetRenderList();
  }
}
