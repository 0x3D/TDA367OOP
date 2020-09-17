package com.teamjeaa.obpaint.model;

public class ConcreteToolFactory implements IToolFactory {

    @Override
    public ITool createPencil(int size) {
       return new ConcretePencil(10);
    }

    @Override
    public ITool createBrush(int size) {
        return new ConcreteBrush(20);
    }

    @Override
    public ITool createEraser(int size) {
        return new ConcreteEraser(15);
    }
}
