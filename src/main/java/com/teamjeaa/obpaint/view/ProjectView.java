package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.model.FileManager;
import com.teamjeaa.obpaint.model.shapeModel.ShapeUtil;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class ProjectView {
  public FileManager fileChooser = new FileManager();
  @FXML ToggleButton eraserButton;
  @FXML MenuItem fileChoser;
  @FXML ToggleButton darkModeToggle;
  @FXML AnchorPane mainPain;
  @FXML ColorPicker cp;
  /** Lite go testning bara */
  double x1, y1, x2, y2;
  @FXML ToggleButton rectangleB;
  @FXML ToggleButton circleB;
  @FXML private BorderPane rootBorderPane;

  @FXML
  private void onFileChoser() {
    fileChooser.loaderFile();
  }

  @FXML
  public void onClose() {
    Platform.exit();
  }

  @FXML
  public void darkModeOn() {
    if (darkModeToggle.isSelected()) {
      mainPain.setStyle("-fx-background-color: rgb(45,45,45)");
    } else {
      mainPain.setStyle("-fx-background-color: transparent");
    }
  }
  /*
  public String getColor() {
  	return cp.getValue().toString();
  }

   */

  public BorderPane getRootBorderPane() {
    return rootBorderPane;
  }

  @FXML
  public Shape onRectangleButton() {
    // Positions of the corners of the rectangle

    x2 = x1 + 100;
    y2 = y1 + 100;
    Shape rectangle = ShapeUtil.createRectangle(x1, y1, x2, y2);
    rectangle.setStroke(cp.getValue());
    rectangle.setFill(Color.TRANSPARENT);
    return rectangle;
  }

  @FXML
  public Shape onCircleButton() {
    Shape circle = ShapeUtil.createCircle(x1, y1, 30);
    circle.setStroke(cp.getValue());
    circle.setFill(Color.TRANSPARENT);
    return circle;
  }

  @FXML
  public void placeRectangleShape(MouseEvent event) {
    if (rectangleB.isSelected()) {
      Shape activeShape = onRectangleButton();
      ShapeUtil.moveBy(activeShape, (int) event.getX(), (int) event.getY());
      rootBorderPane.getChildren().add(activeShape);
    } else if (circleB.isSelected()) {
      Shape activeShape = onCircleButton();
      ShapeUtil.moveBy(activeShape, (int) event.getX(), (int) event.getY());
      rootBorderPane.getChildren().add(activeShape);
    }
  }

  public void onEraserButton(MouseEvent event) {
    if (eraserButton.isSelected()) {
      for (Node s : rootBorderPane.getChildren()) {
        getRootBorderPane().getChildren().remove(s);
      }
    }
  }

  /*
  public void getMouseXPos () {
  	rootBorderPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
  		@Override
  		public void handle(MouseEvent mouseEvent) {
  			x1 = mouseEvent.getX();
  		}
  	});
  }
  public void getMouseYPos () {
  	rootBorderPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
  		@Override
  		public void handle(MouseEvent mouseEvent) {
  			y1 = mouseEvent.getY();
  		}
  	});
  }

   */

}
