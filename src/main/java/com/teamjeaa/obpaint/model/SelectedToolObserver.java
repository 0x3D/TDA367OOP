package com.teamjeaa.obpaint.model;

/**
 * This interface entities able to observe the current selected tool in the model The interface is
 * used by model to notify the observers The interface is implemented by CanvasController
 *
 * @author Jonas N
 * @since 0.1 SNAPSHOT
 * @see com.teamjeaa.obpaint.controller.CanvasController
 */
public interface SelectedToolObserver {

  /**
   * Ran by the observable entity to notify its observer that the selected tool in model has changed
   */
  void selectedToolHasChanged();
}
