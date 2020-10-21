package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EraserTest {

  @Test
  void executeTest() {
    int x = 15;
    int y = 15;
    Command command = new AddRectangle(90, 90, 95, 95, new Color(255, 175, 175), "test");
    Command command1 = new AddRectangle(10, 10, 20, 20, new Color(255, 175, 175), "test");
    command.execute();
    command1.execute();

    Command removeCommand = new Eraser(x, y);
    int size = Model.INSTANCE.getCanvasShapes().size();
    removeCommand.execute();

    assertEquals(size - 1, Model.INSTANCE.getCanvasShapes().size());
  }
}
