package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.ModelCanvas;

public class CircleCommand implements Command{

    private final int centerPoint;
    private final int semiAxesA;
    private final int x2;
    private final int y2;
    private final ModelCanvas modelCanvas;

    public CircleCommand(int centerPoint, int semiAxesA, int x2, int y2, ModelCanvas modelCanvas) {
        this.centerPoint =centerPoint;
        this.semiAxesA = semiAxesA;
        this.x2 = x2;
        this.y2 = y2;
        this.modelCanvas = modelCanvas;
    }

    @Override
    public void execute() {

    }
}
