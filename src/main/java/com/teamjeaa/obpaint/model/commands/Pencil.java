package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public final class Pencil implements Command {
    private final List<Mpoint> points;
    private final Color color;
    private final int strokeSize;


    public Pencil(List<Mpoint> points, Color color, int strokeSize) {
        this.points = points;
        this.color = color;
        this.strokeSize = strokeSize;
    }

    @Override
    public void execute() {
        ShapeFactory shapeFactory = new ConcreteShapeFactory();
        Model.INSTANCE.addToRender(shapeFactory.createPolyline(points, color));
    }
}
