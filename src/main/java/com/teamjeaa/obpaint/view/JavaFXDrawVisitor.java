package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.model.shapeModel.Mellipse;
import com.teamjeaa.obpaint.model.shapeModel.Mpolygon;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class JavaFXDrawVisitor implements DrawVisistor{
  private final BorderPane rootBorderPane;

  public JavaFXDrawVisitor(BorderPane rootBorderPane) {
    this.rootBorderPane = rootBorderPane;
  }

  @Override
  public void visitMellipse(Mellipse mellipse) {
    Ellipse ellipse = new Ellipse(mellipse.getPosition().getX(),mellipse.getPosition().getY(),mellipse.getSemiAxesA(),
            mellipse.getSemiAxesB());
    rootBorderPane.getChildren().add(ellipse);
  }

  @Override
  public void visitMpolyogon(Mpolygon mpolygon) {
    //TODO: implement
  }
}
