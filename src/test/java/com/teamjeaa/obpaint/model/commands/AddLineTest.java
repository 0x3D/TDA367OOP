package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddLineTest {

  @Test
  void executeTest() {
    final int x = 5;
    final int y = 0;
    final int x2 = 10;
    final int y2 = 10;
    final Command command = new AddLine(x, y, x2, y2, new Color(255, 175, 175), "test",1);
    final int size = Model.INSTANCE.getCanvasShapes().size();
    command.execute();
    assertEquals(size + 1, Model.INSTANCE.getCanvasShapes().size());
  }
}
