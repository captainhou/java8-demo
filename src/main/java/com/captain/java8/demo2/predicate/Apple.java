package com.captain.java8.demo2.predicate;

public class Apple {
	private String color;
	private int size;

	public Apple(String color, int size) {
		super();
		this.color = color;
		this.size = size;
	}

	public boolean isBigApple() {
		return this.size >= 100;
	}

	public boolean checkColor(String color) {
		return this.color.equals(color);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "(" + color + "," + size + ")";
	}

}
