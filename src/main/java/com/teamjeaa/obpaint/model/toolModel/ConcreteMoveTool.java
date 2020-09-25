package com.teamjeaa.obpaint.model.toolModel;

import javafx.scene.shape.Shape;

/**
 * Class that holds the logic when we move all of our tools
 */
public class ConcreteMoveTool implements Tool {


  /**
   * initializing from the TOOL- interface
   */
  @Override
  public void initialize() {
  }

  @Override
  public void startUse(Double x1, Double y1) {

  }

  @Override
  public Shape stopUse(Double x1, Double y1) {
    return null;
  }


//TODO Getter för denna är konstigt
  /**
   * getter of our mover
   * @return
   */
  // TODO is this really fitting for public interface?
  public int getSize() {
    return 0;
  }
}
