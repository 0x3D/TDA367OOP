package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import javafx.scene.Node;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import org.junit.Test;
import org.junit.Assert;

public class shapeTest {
    ConcreteShapeFactory concreteShapeFactory = new ConcreteShapeFactory();


    public Shape createCircle() {
         Shape circle = concreteShapeFactory.createCircle(20,20,10);
         return circle;
    }
    public Shape createRectangle() {
        Shape rectangle = concreteShapeFactory.createRectangle(0,0,0,0);
        return rectangle;
    }


    @Test
    public void testMove() {
        double totX = 0;

        Shape rectangle = createRectangle();
        Translate translate = new Translate();
        translate.setX(40);
        translate.setY(40);
        rectangle.getTransforms().addAll(translate);
        // Kollar alla translate totala
        for (Transform translate1 : rectangle.getTransforms())  {
            totX += translate1.getTx();
        }
        System.out.println(totX);
        Assert.assertEquals(totX, 40,0.5);
    }


}
