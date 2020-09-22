package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.model.toolModel.ConcreteToolFactory;
import com.teamjeaa.obpaint.model.toolModel.Tool;
import com.teamjeaa.obpaint.model.toolModel.ToolFactory;
import org.junit.Assert;
import org.junit.Test;
import java.util.Scanner;
public class toolTest {
    ToolFactory toolFactory = new ConcreteToolFactory();
    Scanner sc = new Scanner(System.in);


    private Tool createPencil() {
         return toolFactory.createPencil(10);
    }

    private Tool createBrush() {
        return toolFactory.createBrush(20);
    }

    private Tool createEraser() {
        return toolFactory.createEraser(20);
    }

    /*
    @Test
    public void testPencil (){
       Tool pencil = createPencil();
        Assert.assertEquals(10, pencil.getSize());
    }

    @Test
    public void testBrush () {
        Tool brush = createBrush();
        Assert.assertEquals(20,brush.getSize());
    }
    @Test
    public void testEraser () {
        Tool eraser = createEraser();
        Assert.assertEquals(15,eraser.getSize());
    }
    */

}
