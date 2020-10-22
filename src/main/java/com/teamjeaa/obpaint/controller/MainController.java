package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.fileManager.FileManager;
import com.teamjeaa.obpaint.fileManager.SvgDrawVisitor;
import com.teamjeaa.obpaint.fileManager.SvgParser;
import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.server.ObPaintClient;
import com.teamjeaa.obpaint.view.DrawVisitor;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ResourceBundle;

/**
 * This class provides a controller for the main view
 *
 * <p>This class is used as the controller for the main view The class implements the interface
 * Initializable and is used by mainView.fxml
 *
 * @author Jonas N
 * @since 0.3-SNAPSHOT
 */
public final class MainController implements Initializable {
  /**
   * FXML instances that holds the object in SceneBuilder
   */
  private @FXML
  AnchorPane mainPane;

  private @FXML
  ToggleButton darkModeToggle;
  private @FXML
  AnchorPane startPagePane;
  private @FXML
  AnchorPane canvasViewRoot;
  private @FXML
  Button blancTemplateButton;
  private @FXML
  Button blackTemplateButton;
  private @FXML
  Button redTemplateButton;
  private @FXML
  Button limeTemplateButton;
  private @FXML
  AnchorPane messagePane;
  private @FXML
  AnchorPane serverPane;
  private @FXML
  AnchorPane serverPaneChild;
  private @FXML
  TextField portTF;
  private @FXML
  TextField ipTF;
  private @FXML
  Button connectButton;
  private @FXML
  AnchorPane aboutPage;

  /**
   * Controllers that doesn't seems it's used, but it is. When you name a included FXML file in to
   * an other FXML file. It's needed that the name is exactly like this, otherwise it wont work
   */
  @FXML
  private ToolController toolViewController;

  @FXML
  private CanvasController canvasViewController;
  @FXML
  private ObjectListController objectListController;
  @FXML
  private ShapeInfoController shapeInfoViewController;

  /**
   * initialize the startpane of obPaint
   */
  @FXML
  private void initializeStartPage() {
    startPagePane.toFront();
    startPagePane.setStyle("-fx-background-color: white");
    serverPane.toBack();
    serverPane.toBack();
  }

  /**
   * This method initializes the controller for MainView
   *
   * @param location  - The location used to resolve relative paths for the root object
   * @param resources - The resources used to localize the root object
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    initializeStartPage();
    toolViewController.setCanvasController(canvasViewController);
    canvasViewController.setObjectListController(objectListController);
    objectListController.setParentController(this);
    portTF.setVisible(false);
    ipTF.setVisible(false);
    connectButton.setVisible(false);
    serverPane.setVisible(false);
    serverPaneChild.setVisible(false);
  }

  /**
   * MenuItem that use this method to close the program
   */
  @FXML
  private void onClose() {
    Platform.exit();
  }

  /**
   * MenuItem that uses this metohos to save a .svg file
   */
  @FXML
  private void onSave() {
    String output = FileManager.createSvg();
    FileChooser fileChooser = new FileChooser();
    Window window = new Stage();
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("svg", "*.svg"));
    File file = fileChooser.showSaveDialog(window);

    try {
      PrintWriter writer = new PrintWriter(file, StandardCharsets.UTF_8);
      writer.print(output);
      writer.flush();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Opens a saved file
   */
  @FXML
  private void openFile() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open file");
    fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("svg", "*.svg"),
            new FileChooser.ExtensionFilter("all files", "*.*"));

    Window window = new Stage();
    File testFile = fileChooser.showOpenDialog(window);
    SvgParser svgParser = new SvgParser();
    svgParser.openFile(testFile);
    svgParser.parseFile();
    List<Mshape> openedShapes = svgParser.getMshapeList();
    Model.INSTANCE.removeAllShapes();
    for (Mshape mshape : openedShapes) {
      Model.INSTANCE.addToRender(mshape);
    }
  }

  /**
   * Puts darkmode on in obPaint so the progam gets a darker look.
   */
  @FXML
  private void darkModeOn() {
    if (darkModeToggle.isSelected()) {
      mainPane.setStyle("-fx-background-color: rgb(45,45,45)");
    } else {
      mainPane.setStyle("-fx-background-color: rgb(244,244,244)");
    }
  }

  /**
   * Gets you back to the templatePane so you can chose a new template if wanted
   */
  @FXML
  private void backToTemplates() {
    startPagePane.setVisible(true);
    startPagePane.toFront();
  }

  /**
   * Blanc Theme
   */
  @FXML
  private void onBlancTemplate() {
    canvasViewController.getCanvasPane().setStyle("-fx-background-color: White");
    startPagePane.setVisible(false);
  }

  /**
   * Black Theme
   */
  @FXML
  private void onBlackTemplate() {
    canvasViewController.getCanvasPane().setStyle("-fx-background-color: Black");
    startPagePane.setVisible(false);
  }

  /**
   * Red Theme
   */
  @FXML
  private void onRedTemplate() {
    canvasViewController.getCanvasPane().setStyle("-fx-background-color: red");
    startPagePane.setVisible(false);
  }

  /**
   * Lime Theme
   */
  @FXML
  private void onLimeTemplate() {
    canvasViewController.getCanvasPane().setStyle("-fx-background-color: Lime");
    startPagePane.setVisible(false);
  }

  /**
   * Updates the shapeInfo on a clicked shape in the objectListView. ObjectListView holds a list on
   * the object that are rendered on the rootBorderPane
   *
   * @param mshape - is the sape that the info is about
   */
  public void updateShapeInfo(Mshape mshape) {
    shapeInfoViewController.updateInfo(mshape);
  }

  /**
   * removes all the shapes from the renderList
   */
  @FXML
  private void onRemoveAll() {
    messagePane.setVisible(true);
    messagePane.toFront();
    messagePane.setStyle("-fx-background-color: darkgrey");
  }

  /**
   * Is a yesButton. If you press yes you will remove all shapes WarningButton
   */
  @FXML
  private void onYesButton() {
    Model.INSTANCE.removeAllShapes();
    messagePane.toBack();
    messagePane.setVisible(false);
  }

  /**
   * CancelButton that you can press if you regrett that you want to remove all shapes
   */
  @FXML
  private void onCancelButton() {
    messagePane.toBack();
    messagePane.setVisible(false);
  }

  /**
   * Undos the last move
   */
  @FXML
  private void onUndoButton() {
    Model.INSTANCE.undo();
  }

  /**
   * Serverbutton that opens a Pane there you can type in the information needed to collaborate with
   * a friend
   */
  @FXML
  private void onServerButton() {
    serverPane.toFront();
    serverPane.setVisible(true);
    serverPaneChild.setVisible(true);
    portTF.setVisible(true);
    ipTF.setVisible(true);
    connectButton.setVisible(true);
    portTF.setText("1337");
  }

  /**
   * Gets you back to the normal mainPane
   */
  @FXML
  private void onCloseServerPane() {
    serverPane.toBack();
    serverPane.setVisible(false);
    serverPaneChild.setVisible(false);
    portTF.setVisible(false);
    ipTF.setVisible(false);
    connectButton.setVisible(false);
  }

  /**
   * Connects to the CollaborateServer
   */
  @FXML
  private void onConnectButton() {
    ObPaintClient.INSTANCE.connect(ipTF.getText(), Integer.parseInt(portTF.getText()));
  }

  /**
   * Blocks the mouse so you can click on a pane
   *
   * @param event - is a mouseClick event in javaFx
   */
  @FXML
  private void blockMouse(Event event) {
    event.consume();
  }

  /**
   * opens the AboutPane
   */
  @FXML
  private void openAbout() {
    aboutPage.setVisible(true);
    aboutPage.toFront();
  }

  /**
   * Closes the aboutPane
   */
  @FXML
  private void closeAbout() {
    aboutPage.setVisible(false);
    aboutPage.toBack();
  }


}
