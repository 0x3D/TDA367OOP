package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EraserTest {

  @Test
  void executeTest() {
    final int x = 15;
    final int y = 15;
    final Command command = new AddRectangle(90, 90, 95, 95, new Color(255, 175, 175), "test");
    final Command command1 = new AddRectangle(10, 10, 20, 20, new Color(255, 175, 175), "test");
    command.execute();
    command1.execute();

    final Command removeCommand = new Eraser(x, y);
    final int size = Model.INSTANCE.getCanvasShapes().size();
    removeCommand.execute();

    assertEquals(size - 1, Model.INSTANCE.getCanvasShapes().size());
  }
}
