package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.Model;
import com.teamjeaa.obpaint.model.shapeModel.Mpoint;
import com.teamjeaa.obpaint.model.shapeModel.Mshape;

public class Move implements Command {


    private final int mouseDownX;
    private final int mouseDownY;
    private final int mouseUpX;
    private final int mouseUpY;
    private final Model model = Model.INSTANCE;

    public Move(int mouseDownX, int mouseDownY, int mouseUpX, int mouseUpY) {
        this.mouseDownX = mouseDownX;
        this.mouseDownY = mouseDownY;
        this.mouseUpX = mouseUpX;
        this.mouseUpY = mouseUpY;
    }

    @Override
    public void execute() {
        try {
            Mshape shapeToMove = Model.INSTANCE.findShapeAtPoint(mouseDownX,mouseDownY);
            model.removeFromRenderByPoint(mouseDownX,mouseDownY);
            int shapeToMoveX = shapeToMove.getPosition().getX();
            int shapeToMoveY = shapeToMove.getPosition().getY();
            int mouseDeltaX = mouseUpX - mouseDownX;
            int mouseDeltaY = mouseUpY - mouseDownY;
            model.addToRender(shapeToMove.translate(mouseDeltaX,mouseDeltaY));
        } catch (IllegalArgumentException e) {
            System.out.println("Found no object to move");
        }
    }
}
