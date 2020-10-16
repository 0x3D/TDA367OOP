package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveTest {

  @Test
  void excecuteTest() {
    ShapeFactory sp = new ConcreteShapeFactory();
    Mshape mshape = sp.createRectangle(0, 0, 10, 10, Color.WHITE, "test");
    Model.INSTANCE.addToRender(mshape);
    int x = 0;
    int x1 = 40;
    int y = 0;
    int y1 = 40;
    Command cmnd = new Move(x, y, x1, y1);
    cmnd.execute();
    assertEquals(mshape.translate(40, 40), Model.INSTANCE.findShapeAtPoint(40, 40));
  }
}
