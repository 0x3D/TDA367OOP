package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.model.shapeModel.Mellipse;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.Mpolygon;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;

public class JavaFXDrawVisitor implements DrawVisistor {
  private final BorderPane rootBorderPane;

  public JavaFXDrawVisitor(BorderPane rootBorderPane) {
    this.rootBorderPane = rootBorderPane;
  }

  @Override
  public void visitMellipse(Mellipse mellipse) {
    Ellipse ellipse =
        new Ellipse(
            mellipse.getPosition().getX(),
            mellipse.getPosition().getY(),
            mellipse.getSemiAxesA(),
            mellipse.getSemiAxesB());
    ellipse.setFill(
        new Color(
            mellipse.getColor().getRed() / 255.0,
            mellipse.getColor().getGreen() / 255.0,
            mellipse.getColor().getBlue() / 255.0,
            mellipse.getColor().getAlpha() / 255.0));
    rootBorderPane.getChildren().add(ellipse);
  }

  @Override
  public void visitMpolyogon(Mpolygon mpolygon) {
    Polygon polygon = new Polygon();
    for (Mpoint mpoint : mpolygon.getPoints()) {
      polygon
          .getPoints()
          .addAll((double) mpoint.getX(), (double) mpoint.getY()); // TODO: Make prettier
    }
    polygon.setFill(
        new Color(
            mpolygon.getColor().getRed() / 255.0,
            mpolygon.getColor().getGreen() / 255.0,
            mpolygon.getColor().getBlue() / 255.0,
            mpolygon.getColor().getAlpha() / 255.0));
    rootBorderPane.getChildren().add(polygon);
  }
}
