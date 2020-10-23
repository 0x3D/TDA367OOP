package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PencilTest {

    private Command command;


    @Test
    void executeTest(){
        ArrayList<Mpoint> points = new ArrayList<>();
        points.add(new Mpoint(1,1));
        points.add(new Mpoint(2,2));
        points.add(new Mpoint(3,3));
        points.add(new Mpoint(4,4));
        command = new Pencil(points, new Color(255, 175, 175), "test",1);
        int size = Model.INSTANCE.getCanvasShapes().size();
        command.execute();
        assertEquals(size + 1, Model.INSTANCE.getCanvasShapes().size());
    }

    @Test
    void undoTest(){
        executeTest();
        int size = Model.INSTANCE.getCanvasShapes().size();
        command.undo();
        assertEquals(size - 1, Model.INSTANCE.getCanvasShapes().size());
    }
}
