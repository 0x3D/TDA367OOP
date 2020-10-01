package com.teamjeaa.obpaint.controller;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.Observer;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;
import com.teamjeaa.obpaint.model.toolModel.Tool;
import com.teamjeaa.obpaint.view.JavaFXDrawVisitor;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import java.util.ResourceBundle;

/** */
public class CanvasController implements Initializable, Observer {
    @FXML
    BorderPane rootBorderPane;
    Model backend;
    Tool selectedTool;
    private JavaFXDrawVisitor javaFXDrawVisitor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backend = Model.getInstance();
        selectedTool = backend.getSelectedTool();
        backend.addObserver(this);
        initMouseActions();
        javaFXDrawVisitor = new JavaFXDrawVisitor(rootBorderPane);
        AnimationTimer animationTimer =
                new AnimationTimer() {
                    public void handle(long now) {
                        render();
                    }
                };
        animationTimer.start();
    }

    private void render() {

        // GraphicsContext fgcx = foreground.getGraphicsContext2D();
        // fgcx.clearRect(0,0,600,600);
        for (Mshape s : backend.getCanvasShapes()) {
            // It wants the old one to be removed if already is a child.
            s.acceptDrawVisitor(javaFXDrawVisitor);
        }
    }

    @Override
    public void selectedToolHasChanged() {
        selectedTool = backend.getSelectedTool();
    }

    private void initMouseActions() {
//    rootBorderPane.setOnMouseClicked(
//      mouseEvent -> initialMouseClick(mouseEvent.getX(), mouseEvent.getY()));
        rootBorderPane.setOnMousePressed(
                mouseEvent -> {selectedTool.startUse(mouseEvent.getX(), mouseEvent.getY());mouseEvent.consume();System.out.println(mouseEvent.getX()+" "+mouseEvent.getY());});
        rootBorderPane.setOnMouseReleased(mouseEvent -> stopUse(mouseEvent.getX(), mouseEvent.getY()));
    }

    private void initialMouseClick(Double x, Double y) {
        Mshape s = selectedTool.initialMouseClick(x, y);
    }

    public void stopUse(Double x, Double y) {
        System.out.println(x + " " + y);
        Mshape s = selectedTool.stopUse(x,y);
        backend.addToRender(s);
    }

}
