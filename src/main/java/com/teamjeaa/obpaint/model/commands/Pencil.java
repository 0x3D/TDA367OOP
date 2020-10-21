package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;
import com.teamjeaa.obpaint.server.ObPaintClient;


import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for executing command by adding a Mpolyline to program.
 *  Also responsible for undoing the executed action.
 *
 *
 * Used by ToolController
 * Uses Color, Mshape, ShapeFactory, Model, Math
 *
 * @author Jonas N
 * @since 0.3-SNAPSHOT
 */
public final class Pencil implements Command {
    private final List<Mpoint> points;
    private final Color color;
    private final String name;
    private Mshape pencil;
    private final int strokeWidth;

    /**
     * Constructor class for creating Pencil command.
     * @param points list of points that will be used creating Mpolyline
     * @param color Color of line
     * @param name name of line
     * @param strokeWidth width of the line
     */
  public Pencil(List<Mpoint> points, Color color, String name, int strokeWidth) {
    this.points = points;
    this.color = color;
    this.name = name;
    this.strokeWidth = strokeWidth;
  }

    /**
     * Executes command by creating a Mpolyline through shape factory.
     * Adds Mpolyline to render and adds command to list of command.
     */
    @Override
    public void execute() {
        ShapeFactory shapeFactory = new ConcreteShapeFactory();
        //removeDuplicatePoints(points);
        removeUnnecessaryPoints(points);
        pencil = shapeFactory.createPolyline(points, color, name, strokeWidth);
        Model.INSTANCE.addToRender(pencil);
        Model.INSTANCE.addToCommandList(this);
        if (ObPaintClient.INSTANCE.isConnected()) {
            ObPaintClient.INSTANCE.sendPencilStroke(points,color,name, strokeWidth);
        }
    }

    /**
     * Executes command by removing the previously added Mpolyline.
     */
    @Override
    public void undo() {
        Model.INSTANCE.removeFromRender(pencil);
    }

    /**
     * Removes points in line that is too close to previous.
     * @param points List of point that is used to create Mpolyline.
     */
    private void removeUnnecessaryPoints(List<Mpoint> points) {
        for (int i = 0; i < points.size() - 1; i++) {
            Mpoint point1 = points.get(i);
            Mpoint point2 = points.get(i + 1);

            if (Math.abs(point1.getX()-point2.getX()) < 8 && Math.abs(point1.getY()-point2.getY()) < 8) {
                points.remove(i);
                i--;
            }
        }
    }
}
