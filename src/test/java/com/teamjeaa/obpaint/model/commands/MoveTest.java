package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveTest {

  @Test
  void executeTest() {
    ShapeFactory sp = new ConcreteShapeFactory();
    Mshape mshape = sp.createRectangle(0, 0, 10, 10, new Color(255, 175, 175), "test");
    Model.INSTANCE.addToRender(mshape);
    int x = 0;
    int x1 = 40;
    int y = 0;
    int y1 = 40;
    Command cmd = new Move(x, y, x1, y1);
    cmd.execute();
    assertEquals(mshape.translate(40, 40), Model.INSTANCE.findShapeAtPoint(40, 40));
  }
}
