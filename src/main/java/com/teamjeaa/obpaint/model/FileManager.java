package com.teamjeaa.obpaint.model;

import com.teamjeaa.obpaint.ObPaint;
import javafx.stage.FileChooser;

/** Filemanager that holds the logic for the file we want to load and maybe in the future save */
public class FileManager {
  /** New fileChoser object that helps us load in diffrent formats */
  final FileChooser fileChooser = new FileChooser();

  /**
   * Method that holds the info for the file that you want to be loaded
   *
   */
  public void loaderFile() {
    fileChooser.setTitle("Open Image");
    fileChooser
        .getExtensionFilters()
        .addAll(new FileChooser.ExtensionFilter("Image Files", "*.png"));

    fileChooser.showOpenDialog(ObPaint.primaryStage);
  }
}
