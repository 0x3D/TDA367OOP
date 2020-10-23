package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddRectangleTest {

  // ModelCanvas modelCanvas = new ModelCanvas();

  @Test
  void executeTest() {
    final int x = 0;
    final int y = 0;
    final int x2 = 10;
    final int y2 = 10;
    final Command command = new AddRectangle(x, y, x2, y2, new Color(255, 175, 175), "test");
    // Exception exception = assertThrows(IllegalArgumentException.class, () ->
    // modelCanvas.findShapeAt(0, 0));
    final int size = Model.INSTANCE.getCanvasShapes().size();
    command.execute();
    assertEquals(size + 1, Model.INSTANCE.getCanvasShapes().size());
  }
}
