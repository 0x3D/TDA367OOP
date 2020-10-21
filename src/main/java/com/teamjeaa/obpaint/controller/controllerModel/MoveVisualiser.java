package com.teamjeaa.obpaint.controller.controllerModel;


import com.teamjeaa.obpaint.controller.CanvasController;

/**
 * CircleVisualiser is a class thats holds the logic about the visualization
 * when you Moving
 *
 * </p> We only use Javafx shapes to visualize this.
 * Its implemented by ToolVisualiser
 *
 * @author Jonas N
 * @since 0.3-SNAPSHOT
 */
public class MoveVisualiser implements ToolVisualiser {
    private final CanvasController controller;

    public MoveVisualiser(CanvasController controller) {
        this.controller = controller;
    }

    @Override
    public void initiateVisualisation(int x, int y) {

    }

    @Override
    public void updateVisualisation(int x, int y) {
    }

    @Override
    public void endVisualisation() {

    }
}
