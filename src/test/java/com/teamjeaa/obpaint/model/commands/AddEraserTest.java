package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.ModelCanvas;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddEraserTest {
  ModelCanvas modelCanvas = new ModelCanvas();

  @Test
  void executeTest() {
    int x = 15;
    int y = 15;
    Command command = new AddRectangle(90, 90, 95, 95, Color.GRAY, modelCanvas);
    Command command1 = new AddRectangle(10, 10, 20, 20, Color.ORANGE, modelCanvas);
    command.execute();
    command1.execute();
    Command removeCommand = new AddEraser(x, y, modelCanvas);
    removeCommand.execute();
    assertEquals(1, modelCanvas.getShapes().size());
  }
}
