package com.teamjeaa.obpaint.model.shapeModel;
import javafx.scene.shape.Shape;

public interface ShapeFactory {
    Shape createCircle();
    Shape createRectangle();
    Shape createTriangle();
}
