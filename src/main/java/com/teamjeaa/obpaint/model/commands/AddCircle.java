package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;
import com.teamjeaa.obpaint.server.ObPaintClient;



public final class AddCircle implements Command {

  private final int radius;
  private final int centerX;
  private final int centerY;
  private final Color color;
  private final String name;
  private Mshape circle;

  public AddCircle(int radius, int centerX, int centerY, Color color, String name) {
    this.radius = radius;
    this.centerX = centerX;
    this.centerY = centerY;
    this.color = color;
    this.name = name;
  }

  @Override
  public void execute() {
    final ShapeFactory shapeFactory = new ConcreteShapeFactory();
    circle = shapeFactory.createCircle(radius, centerX, centerY, color, name);
    Model.INSTANCE.addToRender(circle);
    Model.INSTANCE.addToCommandList(this);
      if (ObPaintClient.INSTANCE.isConnected()) {
          ObPaintClient.INSTANCE.sendCircle(radius, centerX, centerY,color,name);
      }
  }

  @Override
  public void undo() {
    Model.INSTANCE.removeFromRender(circle);
  }
}
