package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.model.shapeModel.ConcreteShapeFactory;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import org.junit.Test;
import org.junit.Assert;

public class shapeTest {
    ConcreteShapeFactory concreteShapeFactory = new ConcreteShapeFactory();

    public Shape createTriangle() {
        Polygon triangle = (Polygon) concreteShapeFactory.createTriangle();
        triangle.getPoints().addAll(50.0, 0.0,  0.0, 50.0,100.0, 50.0);
        return triangle;
    }
    public Shape createCircle() {
         Shape circle = concreteShapeFactory.createCircle(20,20,10);
         return circle;
    }
    public Shape createRectangle() {
        Shape rectangle = concreteShapeFactory.createRectangle(80,40,20,10);
        return rectangle;
    }


    @Test
    public void testMove() {
        Shape rectangle = createRectangle();
        rectangle.setTranslateX(20);
        rectangle.setTranslateY(20);
        rectangle.translateXProperty().setValue(20);
        System.out.println(rectangle.getLayoutX());
        Assert.assertEquals(rectangle.getLayoutX(), 20.0,0.5);
    }
}
