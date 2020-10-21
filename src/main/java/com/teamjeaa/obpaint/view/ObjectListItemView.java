package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.controller.MainController;
import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ObjectListItemView extends AnchorPane {

  public static final String FXML_OBJECT_LIST_ITEM_VIEW_FXML = "/fxml/objectListItemView.fxml";
  private final Mshape mshape;

  //TODO: Never used in class but crashes program if removed
  private final MainController parentController;


  //IntelliJ cant recognize that these are used
  private @FXML Label objectLabel;
  private @FXML AnchorPane itemPane;
  private @FXML AnchorPane hoverPane;


  public ObjectListItemView(Mshape mshape, MainController mainController) {

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML_OBJECT_LIST_ITEM_VIEW_FXML));
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
    return sb.toString();
  }

  public void setColorBackground() {
    hoverPane.setStyle(colorConverter(mshape));
  }

  //This is used but IntelliJ doesn't recognise because of JavaFX FXML
  @FXML
  public void onClickedListItem() {
    parentController.updateShapeInfo(mshape);
  }

}
