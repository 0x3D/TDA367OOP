package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;


import java.util.ArrayList;
import java.util.List;

public final class Pencil implements Command {
    private final List<Mpoint> points;
    private final Color color;
    private final String name;


    public Pencil(List<Mpoint> points, Color color, String name) {
        this.points = points;
        this.color = color;
        this.name = name;
    }

    @Override
    public void execute() {
        ShapeFactory shapeFactory = new ConcreteShapeFactory();
        removeDuplicatePoints(points);
        Model.INSTANCE.addToRender(shapeFactory.createPolyline(points, color, name));
    }

    private void removeDuplicatePoints(List<Mpoint> points) {
        List<Integer> removeIds = new ArrayList<>();

        for (int i = 0; i < points.size() - 1; i++) {
            Mpoint point1 = points.get(i);
            Mpoint point2 = points.get(i + 1);

            if (point1.getX() == point2.getX() && point1.getY() == point2.getY()) {
                removeIds.add(i);
            }
        }

        for (Integer removeId : removeIds) {
            points.remove(removeId.intValue());
        }
    }
}
