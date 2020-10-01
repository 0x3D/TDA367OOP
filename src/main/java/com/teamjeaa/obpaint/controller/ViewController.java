/*
package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.view.CanvasView;
import com.teamjeaa.obpaint.view.ToolView;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

*/
/*
 * Provides the controller for main window
 *
 * <p>This controller provides method to control the main window. Like toggling dark mode also set up
 * the other controllers. Responsibility Used by Uses
 *
 * @author Jonas N
 * @since 0.1-SNAPSHOT
 *//*

   public class ViewController implements Initializable {

     private static ViewController instance;
     private final ToolController toolController;
     private final CanvasController canvasController;
     @FXML AnchorPane toolViewRoot;
     @FXML AnchorPane canvasViewRoot;
     @FXML AnchorPane mainPane;
     @FXML ToggleButton darkModeToggle;

     private ViewController() {
       this.toolController = new ToolController();
       this.canvasController = new CanvasController();
     }

     public static ViewController getInstance() {
       if (instance == null) {
         instance = new ViewController();
       }
       return instance;
     }

     @Override
     public void initialize(URL location, ResourceBundle resources) {
       */
/*toolViewRoot.getChildren().clear();
toolViewRoot.getChildren().add(new ToolView());

canvasViewRoot.getChildren().clear();
canvasViewRoot.getChildren().add(new CanvasView());*//*

                                                       }

                                                       public ToolController getToolController() {
                                                         return toolController;
                                                       }

                                                       public CanvasController getCanvasController() {
                                                         return canvasController;
                                                       }

                                                       @FXML
                                                       public void onClose() {
                                                         Platform.exit();
                                                       }

                                                       @FXML
                                                       public void darkModeOn() {
                                                         if (darkModeToggle.isSelected()) {
                                                           mainPane.setStyle("-fx-background-color: rgb(45,45,45)");
                                                         } else {
                                                           mainPane.setStyle("-fx-background-color: rgb(244,244,244)");
                                                         }
                                                       }
                                                     }
                                                     */
