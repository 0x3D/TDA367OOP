package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.ModelCanvas;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;

public class AddEraser implements Command {
    private final int x;
    private final int y;


    public AddEraser(int x, int y) {
        this.x = x;
        this.y = y;
    }


    /**
     * executeMethod that will execute our Commands tha tare defined in the Command package,
     * "com\teamjeaa\obpaint\model\commands"
     */
    @Override
    public void execute() {
        Model.INSTANCE.removeFromRenderByPoint(x,y);
    }
}
