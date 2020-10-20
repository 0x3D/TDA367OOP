package com.teamjeaa.obpaint.model;

import java.util.Objects;

/**
 * Simple color class for the model
 *
 * @author Jonas N
 * @since 0.2-SNAPSHOT
 */
public final class Color {
    /**
     * Color range
     */
    private final int red;
    private final int green;
    private final int blue;
    private final int opacity;


    public Color(int red, int green, int blue, int opacity) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.opacity = opacity;
        validateValues();
    }

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.opacity = 255;
        validateValues();
    }


    private void validateValues() throws IllegalArgumentException {
        if (red > 255 || red < 0 ||
            green > 255 || green < 0 ||
            blue > 255 || blue < 0 ||
            opacity > 255 || opacity < 0) {
            throw new IllegalArgumentException("Color not in the range 0-255" + ": " + "r: " + red + ", g: " + green + ", b: " + blue + ", opacity: " + opacity);
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return red == color.red &&
                green == color.green &&
                blue == color.blue &&
                opacity == color.opacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue, opacity);
    }

    @Override
    public String toString() {
        return red + "," + green + "," + blue + "," + opacity;
    }
}
