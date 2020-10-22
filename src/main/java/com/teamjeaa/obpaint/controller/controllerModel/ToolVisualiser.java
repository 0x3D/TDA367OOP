package com.teamjeaa.obpaint.controller.controllerModel;

/**
 * ToolVisualiser interface that holds the methods for our Visualisers
 *
 * @author Erik R
 * @since 0.3-SNAPSHOT
 */
public interface ToolVisualiser {
  /**
   * initiateVisualisation
   *
   * @param x - value to start from
   */
  void initiateVisualisation(int x, int y);

  /**
   * updateVisualisation
   *
   * @param x - value were it ends
   * @param y were it ends
   * @inheritDoc
   */
  void updateVisualisation(int x, int y);

  /** the visualisation {@inheritDocends} */
  void endVisualisation();
}
