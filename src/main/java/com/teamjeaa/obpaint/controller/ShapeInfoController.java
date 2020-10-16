package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.commands.Command;
import com.teamjeaa.obpaint.model.commands.Move;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class ShapeInfoController implements Initializable {
  // TODO: Investigate if this is needed
  ObjectListController objectListController;
  private @FXML TextField xPosition;
  private @FXML TextField yPosition;
  private @FXML ColorPicker colorPicker;
  private Mshape mshape;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    colorPicker.setDisable(true);
  }

  public void updateInfo(Mshape mshape) {
    xPosition.setText(Integer.toString(mshape.getPosition().getX()));
    yPosition.setText(Integer.toString(mshape.getPosition().getY()));
    colorPicker.setValue(
        Color.rgb(
            mshape.getColor().getRed(),
            mshape.getColor().getGreen(),
            mshape.getColor().getBlue(),
            mshape.getColor().getAlpha() / 255f));
    this.mshape = mshape;
  }
  @FXML
  private void onMove () {
   //Mshape shape =  Model.INSTANCE.findShapeAtPoint(Integer.parseInt(xPosition.getText()), Integer.parseInt(yPosition.getText()));
    Command command = new Move(mshape.getPosition().getX(),mshape.getPosition().getY(),
            Integer.parseInt(xPosition.getText()), Integer.parseInt(yPosition.getText()));
    command.execute();
  }

  private void addListeners() {
    xPosition
        .textProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              if (!xPosition.getText().isEmpty()) {
                Command command =
                    new Move(
                        Integer.parseInt(oldValue),
                        Integer.parseInt(yPosition.getText()),
                        Integer.parseInt(newValue),
                        Integer.parseInt(yPosition.getText()));
                command.execute();
              }
            });

    yPosition
        .textProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              if (!yPosition.getText().isEmpty()) {
                Command command =
                    new Move(
                        Integer.parseInt(xPosition.getText()),
                        Integer.parseInt(oldValue),
                        Integer.parseInt(xPosition.getText()),
                        Integer.parseInt(newValue));
                command.execute();
              }
            });
  }
}
