package com.teamjeaa.obpaint.model;

/**
 * Simple color class for the model
 *
 * @author Jonas N
 * @since 0.2-SNAPSHOT
 */
public final class Color {
    private final int red;
    private final int green;
    private final int blue;
    private final int opacity;


    public Color(int red, int green, int blue, int opacity) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.opacity = opacity;
    }

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.opacity = 255;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int getAlpha() {
        return opacity;
    }


}
