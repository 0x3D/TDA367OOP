package com.teamjeaa.obpaint.model.commands;

import com.teamjeaa.obpaint.model.ModelCanvas;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


class AddRectangleTest {
    ModelCanvas modelCanvas = new ModelCanvas();

    @Test
    void executeTest() {
        int x = 0;
        int y = 0;
        int x2 = 10;
        int y2 = 10;
        Command command = new AddRectangle(x, y, x2, y2, Color.ORANGE, modelCanvas, modelCanvas);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> modelCanvas.findShapeAt(0, 0));
        command.execute();
        assertDoesNotThrow(() -> modelCanvas.findShapeAt(x, y));
    }
}