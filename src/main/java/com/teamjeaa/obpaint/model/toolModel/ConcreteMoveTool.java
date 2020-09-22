package com.teamjeaa.obpaint.model.toolModel;

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
