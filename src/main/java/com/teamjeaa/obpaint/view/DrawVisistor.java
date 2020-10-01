package com.teamjeaa.obpaint.view;

import com.teamjeaa.obpaint.model.shapeModel.Mellipse;
import com.teamjeaa.obpaint.model.shapeModel.Mpolygon;

/**
 * This interface provides the methods a visitor has to implement
 *
 * <p>Responsibility Provide an interface to visitors <br>
 * Implemented by JavaFXDrawVisitor <br>
 * Used by Mshape, Mpolygon, Mellipse <br>
 * Uses Mellipse, Mpolygon
 *
 * @author Erik R
 * @since 0.1-SNAPSHOT
 */
public interface DrawVisistor {
  /** The method to implement what should happen when visiting a Mellipse
   * @param mellipse The Mellipse to visit */
  void visitMellipse(Mellipse mellipse);

  /** The method to implement what should happen when visiting a Mpolygon
   * @param mshape The MPolygon to visit*/
  void visitMpolyogon(Mpolygon mshape);
}
