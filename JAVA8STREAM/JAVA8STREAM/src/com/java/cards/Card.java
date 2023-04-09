package com.java.cards;

public class Card {
	String shape;
	String size;
	

	
	public Card(String shape, String size) {
		super();
		this.shape = shape;
		this.size = size;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Card [shape=" + shape + ", size=" + size + "]";
	}

	

}
