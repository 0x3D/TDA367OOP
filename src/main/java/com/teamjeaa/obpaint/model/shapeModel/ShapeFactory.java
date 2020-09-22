package com.teamjeaa.obpaint.model.shapeModel;
import javafx.scene.shape.Shape;

public interface ShapeFactory {
    Shape createCircle(int x1, int y1, int radius);

    Shape createRectangle(int x1, int y1, int x2, int y2);

    Shape createTriangle(double x1, double y1, double x2, double y2, double x3, double y3);
}
