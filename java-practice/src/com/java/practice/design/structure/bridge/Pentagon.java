package com.java.practice.design.structure.bridge;

public class Pentagon extends Shape {

	public Pentagon(Color color) {
		super(color);
	}

	@Override
	void applyColor() {
		System.out.print("Pentagon filled with color ");
		color.applyColor();
	}

}
