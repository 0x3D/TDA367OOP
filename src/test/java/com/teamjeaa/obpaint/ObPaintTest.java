package com.teamjeaa.obpaint;

import com.teamjeaa.obpaint.model.ITool;
import com.teamjeaa.obpaint.model.IToolFactory;
import org.junit.Test;

public class ObPaintTest {
    private IToolFactory iToolFactory;

    private ITool createPencil (int size){
        return iToolFactory.createPencil(size);
    }




}
