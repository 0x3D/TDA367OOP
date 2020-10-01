package com.teamjeaa.obpaint.model.toolModel;

/**
 * interface that holds the methods for creating the Tools. used by ConcreteToolFactory, Uses Tool
 *
 * @author Axel H
 * @see ConcreteToolFactory
 */
public interface ToolFactory {
  /**
   * Creates a Pencil-Object
   *
   * @return a pencil
   */
  Tool createPencil();

  /**
   * Creates a Brush-Object
   *
   * @return a brush
   */
  Tool createBrush();

  /**
   * @param size size of the eraser
   * @return a eraser with a size
   */
  Tool createEraser(int size);

  /**
   * Creates a MoveTool Object
   *
   * @return a new MoveTool
   */
  Tool createMoveTool();
}
