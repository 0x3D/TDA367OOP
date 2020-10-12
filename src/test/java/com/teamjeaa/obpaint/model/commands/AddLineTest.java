package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.ModelCanvas;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AddLineTest {


  @Test
  void executeTest() {
    int x = 5;
    int y = 0;
    int x2 = 10;
    int y2 = 10;
    Command command = new AddLine(x, y, x2, y2, Color.ORANGE);
    assertEquals(0, Model.INSTANCE.getCanvasShapes().size());
    command.execute();
    assertEquals(1,Model.INSTANCE.getCanvasShapes().size());
  }
}
