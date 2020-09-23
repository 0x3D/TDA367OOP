package com.teamjeaa.obpaint.model.toolModel;
import java.util.Scanner;

/**
 * Holds the logic of out Factory
 * Creates all the Tools
 */
public class ConcreteToolFactory implements ToolFactory {

    /**
     * creating the pencil
     * its public because of the //TODO
     * @param size is the size we want
     * @return a new Pencil with a Size
     */
    @Override
    public Tool createPencil(int size) {
       return new ConcretePencil(initFinalSize());
    }

    /**
     * creating the brush
     * its public because of the //TODO
     * @param size is the size we want
     * @return a new Brush with a Size
     */
    @Override
    public Tool createBrush(int size) {
        return new ConcreteBrush(initFinalSize());
    }

    /**
     * creating the Eraser
     * its public because of the //TODO
     * @param size is the size we want
     * @return a new Eraser with a Size
     */
    @Override
    public Tool createEraser(int size) {
        return new ConcreteEraser(initFinalSize());
    }

    /**
     * //TODO
     * @return new ConcreteMoveTool
     */
    @Override
    public Tool createMoveTool() {
        return new ConcreteMoveTool();
    }


    /**
     * This was a methods for the test so we can make a input for our size
     * @return size from the Terminal
     */
    public int initFinalSize () {
        //TODO get in from a textfield or a scroller to get an integer instead of typing in the terminal
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size on your tool: ");
        return  sc.nextInt();
    }
}
