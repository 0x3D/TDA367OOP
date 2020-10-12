package com.teamjeaa.obpaint;

import org.junit.jupiter.api.Test;

class SvgDrawVisitorTest {

  @Test
  void visitMellipse() {

    // StringBuilder sb = new StringBuilder();
    // SvgDrawVisitor svgDrawVisitor = new SvgDrawVisitor(sb);
    // Mellipse mellipse = new Mellipse(
    //        new Mpoint(200,80),100,50, Color.BLACK
    // );
    // svgDrawVisitor.visitMellipse(mellipse);
    // assertEquals("<ellipse cx=\"200\" cy=\"80\" rx=\"100\" ry=\"50\"
    // style=\"fill:yellow;stroke:purple;stroke-width:2\" />", sb.toString());
  }

  @Test
  void visitMpolyogon() {
    /*    StringBuilder sb = new StringBuilder();
    assertEquals(
        "  <polygon fill=\"red\" stroke=\"blue\" stroke-width=\"10\" "
            + "            points=\"350,75  379,161 469,161 397,215"
            + "                    423,301 350,250 277,301 303,215"
            + "                    231,161 321,161\" />",
        sb.toString());*/
  }

  @Test
  void visitMpolyline() {}
}
