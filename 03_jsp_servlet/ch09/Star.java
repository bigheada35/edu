package edu.kosmo.ex.star;

import java.util.ArrayList;

public class Star {
	private int layer;
	private boolean increase;
	private ArrayList<String> stars = new ArrayList<String>();
	
	public Star(int layer, boolean increase) {
		super();
		this.layer = layer;
		this.increase = increase;
	}
	
	public int getLayer() {
		return layer;
	}
	public void setLayer(int layer) {
		this.layer = layer;
	}
	public boolean isIncrease() {
		return increase;
	}
	public void setIncrease(boolean increase) {
		this.increase = increase;
	}

	public ArrayList<String> getStars() {
		String starRow = "";
		if(this.increase) {
			for(int i=0; i<this.layer;i++) {
				starRow = "";
				for(int j=0; j<i+1; j++) {
					starRow += "*";
				}
				stars.add(starRow);	
				System.out.println(starRow);
			}
		}else {
			for(int i=0; i<this.layer;i++) {
				starRow = "";
				for(int j=0; j<layer-i; j++) {
					starRow += "*";
				}
				stars.add(starRow);	
			}
		}	
		
		return stars;
	}
	public void setStars(ArrayList<String> stars) {
		this.stars = stars;
	}

	public ArrayList<String> makeStars() {
		ArrayList<String> stars = null;
//		String starRow = null;
//		if(this.increase) {
//			for(int i=0; i<this.layer;i++) {
//				for(int j=0; j<i+1; j++) {
//					starRow += "*";
//				}
//				stars.add(starRow);	
//			}
//		}else {
//			for(int i=0; i<this.layer;i++) {
//				for(int j=0; j<layer-i; j++) {
//					starRow += "*";
//				}
//				stars.add(starRow);	
//			}
//		}
		return stars;
	}

	
}

