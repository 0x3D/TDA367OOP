package com.teamjeaa.obpaint.model.shapeModel;

import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import com.teamjeaa.obpaint.model.shapeModel.Mellipse;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.awt.*;

public class MellipseTest {
    private final ConcreteShapeFactory concreteShapeFactory = new ConcreteShapeFactory();


    public Mshape createCircle() {
    	// Circle r = 10, y = 20, x = 15
      return concreteShapeFactory.createCircle(10,15,20,Color.BLACK);
    }
   
    @Test
    public void testCircleFactory() {
    	Mshape c = createCircle();
    	assertEquals(Mellipse.class, c.getClass());
    }
    
    @Test
    public void testCircleHeight() {
    	Mshape c = createCircle();
    	assertEquals(20, c.getHeight());
    }

    @Test
    public void testCircleWidth() {
    	Mshape c = createCircle();
    	assertEquals(20, c.getWidth());
    }
    
    @Test
    public void testMove() {
    	Mshape c = createCircle();
    	c = c.translate(5,  40);
    	assertEquals(5, c.getPosition().getX());
    	assertEquals(40, c.getPosition().getY());
    }
    
    
}
