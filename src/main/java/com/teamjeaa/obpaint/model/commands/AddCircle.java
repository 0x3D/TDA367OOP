package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.ModelCanvas;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;

import java.awt.*;

public class AddCircle implements Command{

    private final int radius;
    private final int centerX;
    private final int centerY;
    private final Color color;
    private final ModelCanvas modelCanvas;

    public AddCircle(int radius, int centerX, int centerY, Color color, ModelCanvas modelCanvas) {
        this.radius =radius;
        this.centerX = centerX;
        this.centerY = centerY;
        this.color = color;
        this.modelCanvas = modelCanvas;
    }

    @Override
    public void execute() {
        ShapeFactory shapeFactory = new ConcreteShapeFactory();
        modelCanvas.addToRender(shapeFactory.createCircle(radius,centerX,centerY,color));
    }
}
