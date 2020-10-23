package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.ShapeFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemovaAllShapes {

    private Command command;
    private int size;
    @Test
    void removeAllShapes(){
        ShapeFactory sf = new ConcreteShapeFactory();
        sf.createRectangle(1,1,10,10,new Color(255, 175, 175),"test");
        size = Model.INSTANCE.getCanvasShapes().size();
        command = new RemoveAllShapes();
        command.execute();
        assertEquals(0, Model.INSTANCE.getCanvasShapes().size());
    }

    @Test
    void undoRemoveAllShapes(){
        removeAllShapes();
        command.undo();
        assertEquals(size,Model.INSTANCE.getCanvasShapes().size());
    }
}
