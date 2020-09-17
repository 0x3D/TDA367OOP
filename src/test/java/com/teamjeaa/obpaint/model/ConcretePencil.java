package com.teamjeaa.obpaint.model;

public class ConcretePencil implements ITool{
    private final int size;
    public ConcretePencil(int size) {
        this.size=size;
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
