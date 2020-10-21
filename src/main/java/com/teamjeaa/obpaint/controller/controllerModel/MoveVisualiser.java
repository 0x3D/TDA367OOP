package com.teamjeaa.obpaint.controller.controllerModel;


import com.teamjeaa.obpaint.controller.CanvasController;

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
