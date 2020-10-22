package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.Start;
import com.teamjeaa.obpaint.controller.CanvasController;
import com.teamjeaa.obpaint.controller.ToolController;
import com.teamjeaa.obpaint.model.commands.Command;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;

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
  private final Stack<Command> commandList;

  Model() {
    modelCanvas = new ModelCanvas();
    commandList = new Stack<>();
  }

  public Mshape findShapeAtPoint(final int x, final int y) {
    return modelCanvas.findShapeAt(x, y);
  }

  /**
   * Adds received instance of Mshape to ModelCanvas list for render.
   *
   * @param s some kind of Mshape.
   */
  public void addToRender(final Mshape s) {
    synchronized ("Server") {
      modelCanvas.addToRender(s);
    }
  }

  /**
   * This method adds our commands to a stack so we can handle Undo
   *
   * @param command - Is the command we push to the stack
   */
  public void addToCommandList(final Command command) {
    this.commandList.push(command);
  }

  /** Undo method */
  public void undo() {
    try {
      commandList.pop().undo();
    } catch (final EmptyStackException e) {
      System.out.println("Found no Command to undo");
    }
  }

  /**
   * removes a shape by its points
   *
   * @param x is the xPoint
   * @param y is the yPoint
   */
  public void removeFromRenderByPoint(final int x, final int y) {
    try {
      modelCanvas.removeFromRender(modelCanvas.findShapeAt(x, y));
    } catch (final IllegalArgumentException e) {
      System.out.println("Found no Shape to Remove");
    }
  }

  /**
   * Removes a single shape
   *
   * @param mshape is the shape that being removed
   */
  public void removeFromRender(final Mshape mshape) {
    try {
      modelCanvas.removeFromRender(mshape);
    } catch (final IllegalArgumentException e) {
      System.out.println("Found no Shape to Remove");
    }
  }

  /** @return Returns the list of Mshapes collected from modelCanvas. */
  public List<Mshape> getCanvasShapes() {
    // TODO: Lockable object
    synchronized ("Server") {
      return modelCanvas.getShapes();
    }
  }

  /** removes all shapes from the list */
  public void removeAllShapes() {
    modelCanvas.resetRenderList();
  }
}
