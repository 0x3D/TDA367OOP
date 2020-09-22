package com.teamjeaa.obpaint.model.toolModel;

/**
 * Our Brushtool that takes care of the logic of our brush
 */
public class ConcreteBrush implements Tool {
    /**
     * Size of the brush that is final. We creating a new brush everytime we change the Size
     */
    private final int size;

    /**
     * Constructor for our brush
     * @param size of the brush
     */
    public ConcreteBrush(int size) {
        this.size = size;
    }

    /**
     * initialize our brush
     */
    @Override
    public void initialize() {

    }

    /**
     * getter for get the size of the brush
     * @return brushsize
     */
    // TODO is this really fitting for public interface?
    @Override
    public int getSize() {
        return size;
    }
}
