package com.teamjeaa.obpaint.model.toolModel;

public class ConcreteBrush implements Tool {
    private final int size;

    public ConcreteBrush(int size) {
        this.size = size;
    }

    @Override
    public void initialize() {

    }

    // TODO is this really fitting for public interface?
    @Override
    public int getSize() {
        return size;
    }
}
