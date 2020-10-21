package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.model.commands.Command;
import com.teamjeaa.obpaint.model.commands.Eraser;
import com.teamjeaa.obpaint.model.commands.Move;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * ShapeInfoController is a ControllerClass fot he shapeInfoPane
 * Its Implimented by Initializable that holds a method that initialize the controller
 * Used by MainController. Uses Mshape.
 *
 * @author Axel H
 */
public class ShapeInfoController implements Initializable {
  private static final String STYLE_CLASS_COLOR_PICKER = "button";
  private @FXML
  TextField xPosition;
  private @FXML
  TextField yPosition;
  private @FXML
  ColorPicker colorPicker;
  private Mshape mshape;

  /**
   * Initialize javaFx Controller
   *
   * @param url            -
   * @param resourceBundle -
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    colorPicker.setDisable(true);
    colorPicker.setOpacity(1.0);
    colorPicker.getStyleClass().add(STYLE_CLASS_COLOR_PICKER);
  }

  /**
   * Updates the info about the shape that you clicked on the objectListView
   *
   * @param mshape - is the shape that it updates the info about
   */
  void updateInfo(Mshape mshape) {
    xPosition.setText(Integer.toString(mshape.getPosition().getX()));
    yPosition.setText(Integer.toString(mshape.getPosition().getY()));
    colorPicker.setValue(
            Color.rgb(
                    mshape.getColor().getRed(),
                    mshape.getColor().getGreen(),
                    mshape.getColor().getBlue(),
                    mshape.getColor().getAlpha() / 256f));
    this.mshape = mshape;
  }

  /**
   * onMove method is a method that is called when you press the moveButton
   */
  @FXML
  private void onMove() {
    Command command = new Move(mshape.getPosition().getX(), mshape.getPosition().getY(),
            Integer.parseInt(xPosition.getText()), Integer.parseInt(yPosition.getText()));
    command.execute();
  }

  /**
   * onDeleteButton is the method that is called when you press the deleteButton
   */
  @FXML
  private void onDeleteButton() {
    Command command = new Eraser(
            mshape.getPosition().getX() + (mshape.getWidth() / 2),
            mshape.getPosition().getY() + (mshape.getHeight() / 2));
    command.execute();
  }
}
