package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.ObPaint;
import javafx.stage.FileChooser;

import java.io.File;

/** Filemanager that holds the logic for the file we want to load and maybe in the future save */
public class FileManager {
  /** New fileChoser object that helps us load in diffrent formats */
  FileChooser fileChooser = new FileChooser();

  /**
   * Method that holds the info for the file that you want to be loaded
   *
   * @return selectedFile that you choose
   */
  public File loaderFile() {
    fileChooser.setTitle("Open Image");
    fileChooser
        .getExtensionFilters()
        .addAll(new FileChooser.ExtensionFilter("Image Files", "*.png"));

    File selectedFile = fileChooser.showOpenDialog(ObPaint.primaryStage);
    return selectedFile;
  }
}
