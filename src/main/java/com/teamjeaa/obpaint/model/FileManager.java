package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.ObPaint;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import java.io.File;

public class FileManager {
    FileChooser fileChooser = new FileChooser();

    public File loaderFile () {
        fileChooser.setTitle("Open Image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter
                ("Image Files", "*.png"));

        File selectedFile = fileChooser.showOpenDialog(ObPaint.primaryStage);
        return selectedFile;
    }
}
