package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddCircleTest {

  @Test
  void executeTest() {
    int x = 10;
    int y = 10;
    int radius = 5;

    Command command = new AddCircle(radius, x, y, Color.ORANGE, "test");
    int size = Model.INSTANCE.getCanvasShapes().size();
    command.execute();
    assertEquals(size + 1, Model.INSTANCE.getCanvasShapes().size());
  }
}
