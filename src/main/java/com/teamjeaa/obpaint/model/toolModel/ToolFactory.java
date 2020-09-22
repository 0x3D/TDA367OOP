package com.teamjeaa.obpaint.model.toolModel;

/**
 * interface that holds the methods for creating the Tools
 */
public interface ToolFactory {
     Tool createPencil (int size);
     Tool createBrush (int size);
     Tool createEraser(int size);
     Tool createMoveTool();
}
