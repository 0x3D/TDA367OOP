package com.teamjeaa.obpaint.model.toolModel;

import java.util.Scanner;

/**
 * Holds the logic of out Factory Creates all the Tools, Used By NONE, Uses Scanner, Tool,
 * ToolFactory,ConcretePencil,ConcreteBrush,ConcreteEraser and ConcreteMoveTool
 *
 * @author Axel H
 */
public final class ConcreteToolFactory implements ToolFactory {

  /**
   * creating the pencil its public because of the //TODO
   *
   * @return a new Pencil with a Size
   */
  @Override
  public Tool createPencil() {
    return new ConcretePencil();
  }

  /**
   * creating the brush its public because of the //TODO
   *
   * @return a new Brush with a Size
   */
  @Override
  public Tool createBrush() {
    return new ConcreteBrush();
  }

  /**
   * creating the Eraser its public because of the //TODO
   *
   * @param size is the size we want
   * @return a new Eraser with a Size
   */
  @Override
  public Tool createEraser(int size) {
    return new ConcreteEraser(initFinalSize());
  }

  /**
   * creating a ConcreteMoveTool its public because//TODO
   *
   * @return new ConcreteMoveTool
   */
  @Override
  public Tool createMoveTool() {
    return new ConcreteMoveTool();
  }

  /**
   * This was a methods for the test so we can make a input for our size
   *
   * @return size from the Terminal
   */
  public int initFinalSize() {
    // TODO get in from a text field or a scroller to get an integer instead of typing in the
    // terminal
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Size on your tool: ");
    return sc.nextInt();
  }
}
