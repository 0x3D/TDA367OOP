package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.shapeModel.Mellipse;
import com.teamjeaa.obpaint.model.shapeModel.Mpolygon;
import com.teamjeaa.obpaint.model.shapeModel.Mpolyline;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;

/**
 * Class that implements the DrawVisitor using JavaFX
 *
 * <p>Responsibility implement DrawVisitor using JavaFX <br>
 * Implements DrawVisitor <br>
 * Used by CanvasController <br>
 * Uses Mellipse, Mpoint, Mpolygon, javafx.scene.shape.Ellipse, javafx.scene.Polygon,
 * javafx.scene.paint.Color, javafx.scene.layout.BorderPane
 *
 * @author Erik R
 * @since 0.1-SNAPSHOT
 */
public final class JavaFXDrawVisitor implements DrawVisitor {
  private static final double MODEL_COLOR_TO_JAVAFX_CONST = 256.0;
  private final BorderPane rootBorderPane;

  /** @param rootBorderPane Borderpane to add the JavaFX shape to */
  public JavaFXDrawVisitor(BorderPane rootBorderPane) {
    this.rootBorderPane = rootBorderPane;
  }

  private javafx.scene.paint.Color colorToJavaFXColor(Color color) {
    return new javafx.scene.paint.Color(
        color.getRed() / MODEL_COLOR_TO_JAVAFX_CONST,
        color.getGreen() / MODEL_COLOR_TO_JAVAFX_CONST,
        color.getBlue() / MODEL_COLOR_TO_JAVAFX_CONST,
        color.getAlpha() / MODEL_COLOR_TO_JAVAFX_CONST);
  }

  /** {@inheritDoc} This provides the JavaFX implementation of visitMellipse */
  @Override
  public void visitMellipse(Mellipse mellipse) {
    Ellipse ellipse =
        new Ellipse(
            mellipse.getCenterPoint().getX(),
            mellipse.getCenterPoint().getY(),
            mellipse.getSemiAxesA(),
            mellipse.getSemiAxesB());
    ellipse.setFill(colorToJavaFXColor(mellipse.getColor()));
    rootBorderPane.getChildren().add(ellipse);
    //    ObObjectListControllerjectListController.objectFlowPane.getChildren().add(new ObjectListItemView("FuckOf"));
  }

  /** {@inheritDoc} This provides the JavaFX implementation of visitMpolygon */
  @Override
  public void visitMpolyogon(Mpolygon mpolygon) {
    Polygon polygon = new Polygon();
    // TODO: Make prettier
    mpolygon
        .getPoints()
        .forEach(
            mpoint ->
                polygon
                    .getPoints()
                    .addAll( // TODO: This and visitMpolyline refactor
                        (double) mpoint.getX(), (double) mpoint.getY()));
    polygon.setFill(colorToJavaFXColor(mpolygon.getColor()));
    rootBorderPane.getChildren().add(polygon);
  }

  /** {@inheritDoc} This provides the JavaFX implementation of visitMpolygon */
  @Override
  public void visitMpolyline(Mpolyline mpolyline) {
    Polyline polyline = new Polyline();
    mpolyline
        .getPoints()
        .forEach(
            mpoint -> polyline.getPoints().addAll((double) mpoint.getX(), (double) mpoint.getY()));
    polyline.setStroke(colorToJavaFXColor(mpolyline.getColor()));
    polyline.setStrokeWidth(mpolyline.getStrokeWidth());
    rootBorderPane.getChildren().add(polyline);
  }
}
