package com.teamjeaa.obpaint.model.shapeModel;

import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

public final class ShapeUtil  {

    /**
     * made it private so we cant create a ShapeUtil
     */
    private ShapeUtil() {
        //Do nothing, its like a Static class
    }
    /**
     *
     * @param node is the
     * @param x is the x offset to move the shape
     * @param y is the y offset to move the shape
     */
    public static void moveBy(Node node, int x, int y) {
        Translate translate = new Translate();
        translate.setX(x);
        translate.setY(y);
        node.getTransforms().addAll(translate);
    }

    /**
     *
     * @param node is the Node
     * @return the poitn of the "shape" or Node. We think we need to use this for printing
     * out the position of the objekt when we want.
     */
    public static Point3D getPosOfShape (Node node) {
        double totX = 0;
        double totY= 0;
        double totZ= 0;
        if (!node.getTransforms().isEmpty()) {
            for (Transform transform : node.getTransforms()) {
                totX += transform.getTx();
                totY += transform.getTy();
                totZ += transform.getTz();
            }
        }
        return new Point3D(totX,totY,totZ);
    }

    /**
     * Rotate the node by a angle i degrees from the center of the objekt
     * @param node is the shape
     * @param angle is the angle in degrees that we want to rotate with
     */
    public static void rotateBy (Node node, int angle) {
        //TODO This rotate is F-upped
        node.setRotate(angle);
    }



    public static Shape createCircle(double x1, double y1, int radius) {
        return new Circle(x1,y1,radius);
    }


    public static Shape createRectangle(double x1, double y1, double x2, double y2) {
        return new Rectangle(x1,y1,x2,y2);
    }


    public static Shape createTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        return null;
    }
}
