package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.controller.MainController;
import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.html.ImageView;

import java.io.IOException;

public class ObjectListItemView extends AnchorPane {

  private final Mshape mshape;
  private final MainController parentController;
  private boolean isSelected = false;
  // private final String name;
  private @FXML Label objectLabel;
  private @FXML AnchorPane itemPane;
  private @FXML AnchorPane hoverPane;


  public ObjectListItemView(Mshape mshape, MainController mainController) {

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/objectListItemView.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }
    this.mshape = mshape;
    this.parentController = mainController;
    setColorBackground();
    setLabelName();
  }

  public void setLabelName() {
    //objectLabel.setText("X=" + mshape.getPosition().getX() + " Y=" + mshape.getPosition().getY());
    /*
    double colorIntensity;
    colorIntensity = intensity(mshape.getColor());
    if (colorIntensity < 0.5) {
      objectLabel.setStyle("-fx-text-fill: #FFF");
    }

     */
    objectLabel.setText(mshape.getName());
    objectLabel.setAlignment(Pos.CENTER_LEFT);
  }

  private String colorConverter (Mshape mshape) {
    Color color = mshape.getColor();
    StringBuilder sb = new StringBuilder();
    sb.append("-fx-background-color: rgb(")
            .append(color.getRed())
            .append(",")
            .append(color.getGreen())
            .append(",")
            .append(color.getBlue())
            .append(");");
            //.append("-fx-border-color: grey");
    return sb.toString();
  }

  public void setColorBackground() {
    hoverPane.setStyle(colorConverter(mshape));
  }

  private double intensity(Color color) {
    double intensity;
    double r = color.getRed();
    double g = color.getGreen();
    double b = color.getRed();

    intensity = (r + g + b) / (255 * 3);

    return intensity;
  }

  // TODO: implement button to click this
  @FXML
  public void onClickedListItem() {
    parentController.updateShapeInfo(mshape);
  }
}
