package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.ModelCanvas;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;

import java.awt.*;

public class AddLine implements Command{


    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;
    private final Color color;
    private final ModelCanvas modelCanvas;

    public AddLine(int x1, int y1, int x2, int y2, Color color, ModelCanvas modelCanvas) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.modelCanvas = modelCanvas;
    }

    /**
     * executeMethod that will execute our Commands tha tare defined in the Command package,
     * "com\teamjeaa\obpaint\model\commands"
     */
    @Override
    public void execute() {
        ShapeFactory shapeFactory = new ConcreteShapeFactory();
        modelCanvas.addToRender(shapeFactory.createLine(x1,y1,x2,y2,color));
    }
}
