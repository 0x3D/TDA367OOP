package com.teamjeaa.obpaint.model;

public interface IToolFactory {
     ITool createPencil (int size);
     ITool createBrush (int size);
     ITool createEraser(int size);
}
