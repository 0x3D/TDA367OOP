package com.teamjeaa.obpaint.model.shapeModel;
import javafx.scene.shape.Shape;
import javafx.scene.shape.TriangleMesh;

public interface ShapeFactory {
    Shape createCircle(double xCenter,double yCenter, double radius);
    Shape createRectangle(double x, double y, double width,double height );
    Shape createTriangle();
}
