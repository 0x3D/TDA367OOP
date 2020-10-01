package com.teamjeaa.obpaint.model.toolModel;

/** interface that holds the methods for creating the Tools */
public interface ToolFactory {
  Tool createPencil();

  Tool createBrush();

  Tool createEraser(int size);

  Tool createMoveTool();
}
