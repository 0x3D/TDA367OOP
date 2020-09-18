package com.teamjeaa.obpaint;

import com.teamjeaa.obpaint.model.Tool;
import com.teamjeaa.obpaint.model.ToolFactory;

public class ObPaintTest {
    private ToolFactory toolFactory;

    private Tool createPencil (int size){
        return toolFactory.createPencil(size);
    }




}
