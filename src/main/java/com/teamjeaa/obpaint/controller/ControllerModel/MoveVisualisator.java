package com.teamjeaa.obpaint.controller.ControllerModel;


import com.teamjeaa.obpaint.controller.CanvasController;

public class MoveVisualisator implements ToolVisualisator {
    private final CanvasController controller;

    public MoveVisualisator(CanvasController controller) {
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
