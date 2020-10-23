package com.teamjeaa.obpaint.model;

import java.util.Objects;

/**
 * Simple color class for the model
 *
 * @author Jonas N
 * @since 0.2-SNAPSHOT
 */
public final class Color {
  /** Color range */
  private final int red;

  private final int green;
  private final int blue;
  private final int opacity;

  /**
   * Create color with RGBA
   *
   * @param red Value for red color between 0 and 255
   * @param green Value for green color between 0 and 255
   * @param blue Value for blue color between 0 and 255
   * @param opacity Value for opacity color between 0 and 255
   */
  public Color(final int red, final int green, final int blue, final int opacity) {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.opacity = opacity;
    validateValues();
  }

  /**
   * Create color with RGB
   *
   * @param red Value for red color between 0 and 255
   * @param green Value for green color between 0 and 255
   * @param blue Value for blue color between 0 and 255
   */
  public Color(final int red, final int green, final int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.opacity = 255;
    validateValues();
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Color color = (Color) o;
    return red == color.getRed()
        && green == color.getGreen()
        && blue == color.getBlue()
        && opacity == color.getAlpha();
  }

  @Override
  public int hashCode() {
    return Objects.hash(red, green, blue, opacity);
  }

  @Override
  public String toString() {
    return red + "," + green + "," + blue + "," + opacity;
  }

  private void validateValues() throws IllegalArgumentException {
    if (red > 255
        || red < 0
        || green > 255
        || green < 0
        || blue > 255
        || blue < 0
        || opacity > 255
        || opacity < 0) {
      throw new IllegalArgumentException(
          "Color not in the range 0-255"
              + ": "
              + "r: "
              + red
              + ", g: "
              + green
              + ", b: "
              + blue
              + ", opacity: "
              + opacity);
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
}
