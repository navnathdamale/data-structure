package com.java.practice.design.structure.bridge;

public class Triangle extends Shape {

	public Triangle(Color color) {
		super(color);
	}

	@Override
	void applyColor() {
		System.out.print("Triangle filled with color ");
		color.applyColor();
	}
}
