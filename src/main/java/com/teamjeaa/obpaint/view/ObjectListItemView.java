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

public final class ObjectListItemView extends AnchorPane {

  private static final String FXML_OBJECT_LIST_ITEM_VIEW_FXML = "/fxml/objectListItemView.fxml";
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

  private void setLabelName() {
    objectLabel.setText(mshape.getName());
    objectLabel.setAlignment(Pos.CENTER_LEFT);
  }

  private String colorConverter (Mshape mshape) {
    Color color = mshape.getColor();
    return "-fx-background-color: rgb(" +
            color.getRed() +
            "," +
            color.getGreen() +
            "," +
            color.getBlue() +
            ");";
  }

  private void setColorBackground() {
    hoverPane.setStyle(colorConverter(mshape));
  }

  //This is used but IntelliJ doesn't recognise because of JavaFX FXML
  @FXML
  private void onClickedListItem() {
    parentController.updateShapeInfo(mshape);
  }

}
