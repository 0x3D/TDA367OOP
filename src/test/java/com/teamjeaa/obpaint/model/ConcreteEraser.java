package com.teamjeaa.obpaint.model;

public class ConcreteEraser implements ITool {
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
