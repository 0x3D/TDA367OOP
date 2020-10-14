package com.teamjeaa.obpaint.view;

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
  private final BorderPane rootBorderPane;

  /** @param rootBorderPane Borderpane to add the JavaFX shape to */
  public JavaFXDrawVisitor(BorderPane rootBorderPane) {
    this.rootBorderPane = rootBorderPane;
  }

  private javafx.scene.paint.Color AWTColorToJavaFX(java.awt.Color awtColor) {
    return new javafx.scene.paint.Color(
        awtColor.getRed() / 255.0,
        awtColor.getGreen() / 255.0,
        awtColor.getBlue() / 255.0,
        awtColor.getAlpha() / 255.0);
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
    ellipse.setFill(AWTColorToJavaFX(mellipse.getColor()));
    rootBorderPane.getChildren().add(ellipse);
    //    ObjectListController.objectFlowPane.getChildren().add(new ObjectListItemView("FuckOf"));
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
    polygon.setFill(AWTColorToJavaFX(mpolygon.getColor()));
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
    polyline.setStroke(AWTColorToJavaFX(mpolyline.getColor()));
    rootBorderPane.getChildren().add(polyline);
  }
}
