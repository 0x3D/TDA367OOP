package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;



public final class AddCircle implements Command {

  private final int radius;
  private final int centerX;
  private final int centerY;
  private final Color color;
  private final String name;

  public AddCircle(int radius, int centerX, int centerY, Color color, String name) {
    this.radius = radius;
    this.centerX = centerX;
    this.centerY = centerY;
    this.color = color;
    this.name = name;
  }

  @Override
  public void execute() {
    ShapeFactory shapeFactory = new ConcreteShapeFactory();
    Model.INSTANCE.addToRender(shapeFactory.createCircle(radius, centerX, centerY, color, name));
  }
}
