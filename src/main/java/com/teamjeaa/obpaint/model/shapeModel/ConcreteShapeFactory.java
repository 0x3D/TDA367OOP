package com.teamjeaa.obpaint.model.shapeModel;

import javafx.scene.shape.*;

public class ConcreteShapeFactory implements ShapeFactory {

    public Shape createTriangle() {
        return new Polygon();

    }
    public Shape createRectangle(double x, double y, double width,double height) {
        return new Rectangle();
    }

    public Shape createCircle (double xCenter,double yCenter, double radius){
        return new Circle();
    }


}
