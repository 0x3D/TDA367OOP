package com.teamjeaa.obpaint.model;

import org.junit.Assert;
import org.junit.Test;

public class toolTest {
    ToolFactory toolFactory = new ConcreteToolFactory();


    private Tool createPencil() {
         return toolFactory.createPencil(10);
    }

    private Tool createBrush() {
        return toolFactory.createBrush(20);
    }

    private Tool createEraser() {
        return toolFactory.createEraser(15);
    }

    @Test
    public void testCreate (){
       Tool pencil = createPencil();
       Tool brush = createBrush();
       Tool eraser = createEraser();
        Assert.assertEquals(10, pencil.getSize());
        Assert.assertEquals(20,brush.getSize());
        Assert.assertEquals(15,eraser.getSize());
    }
}
