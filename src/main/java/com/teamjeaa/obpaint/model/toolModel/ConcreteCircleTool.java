package com.teamjeaa.obpaint.model.toolModel;

import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;

public class ConcreteCircleTool implements Tool {
    Mpoint centerPoint;
    private int radie;

    @Override
    public void initialize() {

    }

    @Override
    public void startUse(Double x1, Double y1) {
        centerPoint = new Mpoint(x1.intValue(),y1.intValue());
    }

    @Override
    public Mshape stopUse(Double x, Double y) {
        ShapeFactory shapeFactory = new ConcreteShapeFactory();
        Mpoint cloneStartCenter = centerPoint.clone();
        radie = (int) Math.sqrt(Math.pow(cloneStartCenter.getX()-x.intValue(),2)
                + Math.pow(cloneStartCenter.getY()-y.intValue(),2));
        Mshape circle = shapeFactory.createCircle(radie,centerPoint.getX(),centerPoint.getY());
        return circle;
    }

    @Override
    public Mshape initialMouseClick(double x, double y) {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }
}

