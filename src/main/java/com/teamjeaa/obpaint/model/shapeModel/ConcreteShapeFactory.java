package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.model.toolModel.ConcreteCircleTool;
import com.teamjeaa.obpaint.model.toolModel.ConcreteRectangleTool;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that holds the logic for creating Shapes
 * <p>
 * Responsibility Factory class that creates instances of different Mhapes for model.
 * Used by ConcreteCircleTool, ConcreteRectangleTool
 * Uses Color, Mpoint, Mpolygon, Mellipse, some more tools might be added. Uses ShapeFactort Interface.
 * </p>
 *
 * @author Axel H
 * @see ConcreteCircleTool
 * @see ConcreteRectangleTool
 * @see Mellipse
 * @see Mpoint
 * @see Mpolygon
 * @see ShapeFactory
 * @see Color
 * @since 0.1-SNAPSHOT
 */
public class ConcreteShapeFactory implements ShapeFactory {


  @Override
  public Mshape createCircle(int radius, int x, int y, Color color) {
    return new Mellipse(new Mpoint(x, y, 0), radius, radius, color);
  }


  @Override
  public Mshape createRectangle(int x1, int y1, int x2, int y2, Color color) {
    List<Mpoint> mpointList = new ArrayList<>();
    mpointList.add(new Mpoint(x1, y1));
    mpointList.add(new Mpoint(x2, y1));
    mpointList.add(new Mpoint(x2, y2));
    mpointList.add(new Mpoint(x1, y2));
    return new Mpolygon(mpointList, color);
  }
}
