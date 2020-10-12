package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.SvgDrawVisitor;
import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.view.DrawVisitor;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

/**
 * This class provides a controller for the main view
 *
 * <p>This class is used as the controller for the main view The class implements the interface
 * Initializable and is used by mainView.fxml
 *
 * @author Jonas N
 * @since 0.1-SNAPSHOT
 */
public final class MainController implements Initializable {

  private @FXML AnchorPane mainPane;
  private @FXML ToggleButton darkModeToggle;
  private @FXML AnchorPane startPagePane;
  private @FXML AnchorPane canvasViewRoot;
  private @FXML Button blancTemplateButton;
  private @FXML Button blackTemplateButton;
  private @FXML Button redTemplateButton;
  private @FXML Button limeTemplateButton;
  @FXML private ToolController toolViewController;
  @FXML private CanvasController canvasViewController;

  @FXML
  private void initializeStartPage() {
    startPagePane.toFront();
    startPagePane.setStyle("-fx-background-color: white");
  }

  /**
   * This method initializes the controller for MainView
   *
   * @param location - The location used to resolve relative paths for the root object
   * @param resources - The resources used to localize the root object
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    initializeStartPage();
    toolViewController.setCanvasController(canvasViewController);
  }

  @FXML
  private void onClose() {
    onSave();
    Platform.exit();
  }

  private void onSave() {
    //TODO: Move behaviour to new class
    StringBuilder sb = new StringBuilder();
    DrawVisitor drawVisitor = new SvgDrawVisitor(sb);
    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n");
    sb.append("<svg width=\"")
        .append(800)
        .append("\" height=\"")
        .append(800)
        .append("\" xmlns=\"http://www.w3.org/2000/svg\">\n");
    for(Mshape mshape: Model .INSTANCE.getCanvasShapes()){
      mshape.acceptDrawVisitor(drawVisitor);
    }
    sb.append("\n").append("</svg>");
    try {
      PrintWriter writer = new PrintWriter("output.svg", StandardCharsets.UTF_8);
      writer.print(sb.toString());
      writer.flush();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @FXML
  private void darkModeOn() {
    if (darkModeToggle.isSelected()) {
      mainPane.setStyle("-fx-background-color: rgb(45,45,45)");
    } else {
      mainPane.setStyle("-fx-background-color: rgb(244,244,244)");
    }
  }

  @FXML
  private void backToTemplates() {
    startPagePane.setVisible(true);
    startPagePane.toFront();
  }

  @FXML
  private void onBlancTemplate() {
    canvasViewRoot.setStyle("-fx-background-color: White");
    startPagePane.setVisible(false);
  }

  @FXML
  private void onBlackTemplate() {
    canvasViewRoot.setStyle("-fx-background-color: Black");
    startPagePane.setVisible(false);
  }

  @FXML
  private void onRedTemplate() {
    canvasViewRoot.setStyle("-fx-background-color: red");
    startPagePane.setVisible(false);
  }

  @FXML
  private void onLimeTemplate() {
    canvasViewRoot.setStyle("-fx-background-color: Lime");
    startPagePane.setVisible(false);
  }
}
