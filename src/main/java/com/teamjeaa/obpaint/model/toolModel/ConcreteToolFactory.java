package com.teamjeaa.obpaint.model.toolModel;
import java.util.Scanner;

public class ConcreteToolFactory implements ToolFactory {

    @Override
    public Tool createPencil(int size) {
       return new ConcretePencil(initFinalSize());
    }

    @Override
    public Tool createBrush(int size) {
        return new ConcreteBrush(initFinalSize());
    }

    @Override
    public Tool createEraser(int size) {
        return new ConcreteEraser(initFinalSize());
    }

    @Override
    public Tool createMoveTool() {
        return new ConcreteMoveTool();
    }


    //For tests
    public int initFinalSize () {
        //TODO get in from a textfield or a scroller to get an integer instead of typing in the terminal
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size on your tool: ");
        return  sc.nextInt();
    }
}
