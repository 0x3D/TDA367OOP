package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.controller.ShapeInfoController;
import com.teamjeaa.obpaint.model.Color;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * ObjectListItemView is a class that represent the item that is added on the objectListViews
 * FlowPane. extended by javafx AnchorPane
 *
 * @author Axel H
 * @since SNAPSHOT 0.3.
 */
public final class ObjectListItemView extends AnchorPane {

  private static final String FXML_OBJECT_LIST_ITEM_VIEW_FXML = "/fxml/objectListItemView.fxml";

  private final Mshape mshape;
  private final ShapeInfoController shapeInfoController;

  /** IntelliJ can't recognize that these are used But...they are */
  @FXML
  private Label objectLabel;

  @FXML
  private AnchorPane itemPane;
  @FXML
  private AnchorPane hoverPane;

  /**
   * Constructor for the Item
   *
   * @param mshape we need to get the info about the shape
   * @param shapeInfoController is the controller we sending. Needed in javafx because all visual
   *     things in javafx needs a controller
   */
  public ObjectListItemView(final Mshape mshape, final ShapeInfoController shapeInfoController) {

    final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML_OBJECT_LIST_ITEM_VIEW_FXML));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (final IOException exception) {
      throw new RuntimeException(exception);
    }
    this.mshape = mshape;
    this.shapeInfoController = shapeInfoController;
    setColorBackground();
    setLabelName();
  }

  /** sets the name of the mshape to the label on the listItem */
  private void setLabelName() {
    objectLabel.setText(mshape.getName());
    objectLabel.setAlignment(Pos.CENTER_LEFT);
  }

  /**
   * Converts the Color to javafx color
   *
   * @param mshape holds the color of the shape
   * @return a string of the color info
   */
  private String colorConverter(final Mshape mshape) {
    final Color color = mshape.getColor();
    return "-fx-background-color: rgb("
        + color.getRed()
        + ","
        + color.getGreen()
        + ","
        + color.getBlue()
        + ");";
  }

  /** Sets the backround of the pane to the color that the MShape is holding */
  private void setColorBackground() {
    hoverPane.setStyle(colorConverter(mshape));
  }

  /**
   * this is what is called if you press on a listItem This is used but IntelliJ doesn't recognise
   * because of JavaFX FXML
   */
  @FXML
  private void onClickedListItem() {
    shapeInfoController.updateInfo(mshape);
  }
}
