package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.ModelCanvas;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddCircleTest {

  ModelCanvas modelCanvas = new ModelCanvas();

  @Test
  void executeTest() {
    int x = 10;
    int y = 10;
    int radius = 5;

    Command command = new AddCircle(radius, x, y, Color.ORANGE, modelCanvas);
    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> modelCanvas.findShapeAt(x, y));
    command.execute();
    assertDoesNotThrow(() -> modelCanvas.findShapeAt(13, 13));
  }
}
