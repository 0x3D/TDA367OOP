package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class AddCircleTest {

  private Command command;

  @Test
  void executeTest() {
    final int x = 10;
    final int y = 10;
    final int radius = 5;
    command = new AddCircle(radius, x, y, new Color(255, 175, 175), "test");
    final int size = Model.INSTANCE.getCanvasShapes().size();
    command.execute();
    assertEquals(size + 1, Model.INSTANCE.getCanvasShapes().size());
  }

  @Test
  void undoTest(){
    executeTest();
    final int size = Model.INSTANCE.getCanvasShapes().size();
    command.undo();
    assertEquals(size - 1, Model.INSTANCE.getCanvasShapes().size());
  }
}


