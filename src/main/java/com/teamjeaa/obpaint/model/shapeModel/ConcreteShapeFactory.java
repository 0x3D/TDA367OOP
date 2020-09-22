package com.teamjeaa.obpaint.model.shapeModel;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class ConcreteShapeFactory implements ShapeFactory {
    public Shape createTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        return new Polygon();
    }

    public Shape createRectangle(int x1, int y1, int x2, int y2) {
        return new Rectangle();
    }

    public Shape createCircle(int x1, int y1, int radius) {
        return new Circle();
    }
}
