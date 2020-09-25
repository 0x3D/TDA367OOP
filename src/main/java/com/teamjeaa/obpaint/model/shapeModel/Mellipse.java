package com.teamjeaa.obpaint.model.shapeModel;

public class Mellipse implements Mshape {
	  private final Mpoint centerPoint;
	
	  //Semiaxis for x
	  private final int semiAxesA;
	
	  //Semiaxis for y
	  private final int semiAxesB;
	
	  Mellipse(Mpoint centerPoint, int semiAxesA, int semiAxesB) {
	    this.centerPoint = centerPoint;
	    this.semiAxesA = semiAxesA;
	    this.semiAxesB = semiAxesB;
	  }
	
	  @Override
	  public Mpoint getPosition() {
		  return this.centerPoint;
	  }
	
	  @Override
	  public int getWidth() {
		  return this.semiAxesA * 2;
	  }
	
	  @Override
	  public int getHeight() {
		   return this.semiAxesB * 2;
	  }
	
	  @Override
	  public Mshape translate(int x, int y) {
		    return new  Mellipse(new Mpoint(x, y, 0), this.semiAxesA, this.semiAxesB);
	  }
}