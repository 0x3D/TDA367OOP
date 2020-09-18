package com.teamjeaa.obpaint.model.shapeModel;

import javafx.scene.shape.*;

public class ConcreteShapeFactory implements ShapeFactory {
    public Shape createTriangle() {
        return new Polygon();
    }

    public Shape createRectangle() {
        return new Rectangle();
    }

    public Shape createCircle(){
        return new Circle();
    }
}
