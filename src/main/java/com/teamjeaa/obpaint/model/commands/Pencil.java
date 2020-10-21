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

public final class Pencil implements Command {
    private final List<Mpoint> points;
    private final Color color;
    private final String name;
    private Mshape pencil;
    private int strokeWidth;


    public Pencil(List<Mpoint> points, Color color, String name, int strokeWidth) {
        this.points = points;
        this.color = color;
        this.name = name;
        this.strokeWidth = strokeWidth;
    }

    @Override
    public void execute() {
        ShapeFactory shapeFactory = new ConcreteShapeFactory();
        removeDuplicatePoints(points);
        pencil = shapeFactory.createPolyline(points, color, name,strokeWidth);
        Model.INSTANCE.addToRender(pencil);
        Model.INSTANCE.addToCommandList(this);
        if (ObPaintClient.INSTANCE.isConnected()) {
            ObPaintClient.INSTANCE.sendPencilStroke(points,color,name,strokeWidth);
        }
    }

    @Override
    public void undo() {
        Model.INSTANCE.removeFromRender(pencil);
    }

    private void removeDuplicatePoints(List<Mpoint> points) {
        List<Integer> removeIds = new ArrayList<>();

        for (int i = 0; i < points.size() - 1; i++) {
            Mpoint point1 = points.get(i);
            Mpoint point2 = points.get(i + 1);

            if (point1.equals(point2)) {
                points.remove(i);
                i = 0;
            }
        }
    }
}
