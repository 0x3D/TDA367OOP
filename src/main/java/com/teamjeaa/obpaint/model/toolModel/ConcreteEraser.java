package com.teamjeaa.obpaint.model.toolModel;

public class ConcreteEraser implements Tool {
    private final int size;

    public ConcreteEraser(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void onClick() {

    }

    @Override
    public void operation() {

    }
}
