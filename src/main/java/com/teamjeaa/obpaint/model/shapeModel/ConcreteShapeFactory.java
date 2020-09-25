package com.teamjeaa.obpaint.model.shapeModel;

import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Class that holds the logic for all our creating of Shapes
 * TODO Ska detta vara kvar?
 */
public class ConcreteShapeFactory implements ShapeFactory {

    /**
     * TODO
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @return the Triangle as a Polygon
     */
    public Shape createTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        return new Polygon();
    }

    /**
     * TODO
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return The Rectangle
     */
    public Shape createRectangle(int x1, int y1, int x2, int y2) {
        return new Rectangle();
    }

    @Override
    public Mshape createCircle(int radius, int x, int y) {
        return new Mellipse(new Mpoint(x,y,0),radius,radius);
    }

    /**
     * TODO
     * @param x1
     * @param y1
     * @param radius
     * @return the Circle
     */
    /*public Shape createCircle(int x1, int y1, int radius) {
        return new Circle();
    }*/


}
