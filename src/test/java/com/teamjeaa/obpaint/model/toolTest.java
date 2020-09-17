package com.teamjeaa.obpaint.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

public class toolTest {
    IToolFactory iToolFactory = new ConcreteToolFactory();


    private ITool createPencil() {
         return iToolFactory.createPencil(10);
    }

    private ITool createBrush() {
        return iToolFactory.createBrush(20);
    }

    private ITool createEraser() {
        return iToolFactory.createEraser(15);
    }

    @Test
    public void testCreate (){
       ITool pencil = createPencil();
       ITool brush = createBrush();
       ITool eraser = createEraser();
        Assert.assertEquals(10, pencil.getSize());
        Assert.assertEquals(20,brush.getSize());
        Assert.assertEquals(15,eraser.getSize());
    }
}
