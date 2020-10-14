package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddLineTest {

  @Test
  void executeTest() {
    int x = 5;
    int y = 0;
    int x2 = 10;
    int y2 = 10;
    Command command = new AddLine(x, y, x2, y2, Color.ORANGE);
    int size = Model.INSTANCE.getCanvasShapes().size();
    command.execute();
    assertEquals(size + 1, Model.INSTANCE.getCanvasShapes().size());
  }
}
