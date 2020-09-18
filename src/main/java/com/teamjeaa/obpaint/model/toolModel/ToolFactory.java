package com.teamjeaa.obpaint.model.toolModel;

public interface ToolFactory {
     Tool createPencil (int size);
     Tool createBrush (int size);
     Tool createEraser(int size);
}
