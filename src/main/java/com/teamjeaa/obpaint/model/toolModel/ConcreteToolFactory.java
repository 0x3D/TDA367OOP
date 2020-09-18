package com.teamjeaa.obpaint.model.toolModel;

public class ConcreteToolFactory implements ToolFactory {

    @Override
    public Tool createPencil(int size) {
       return new ConcretePencil(10);
    }

    @Override
    public Tool createBrush(int size) {
        return new ConcreteBrush(20);
    }

    @Override
    public Tool createEraser(int size) {
        return new ConcreteEraser(15);
    }

    @Override
    public Tool createMoveTool() {
        return new ConcreteMoveTool();
    }
}
