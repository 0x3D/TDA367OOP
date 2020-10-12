package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.ModelCanvas;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class AddCircleTest {


  @Test
  void executeTest() {
    int x = 10;
    int y = 10;
    int radius = 5;

    Command command = new AddCircle(radius, x, y, Color.ORANGE);
    assertEquals(0,Model.INSTANCE.getCanvasShapes().size());
    command.execute();
    assertEquals(1,Model.INSTANCE.getCanvasShapes().size());
  }
}
