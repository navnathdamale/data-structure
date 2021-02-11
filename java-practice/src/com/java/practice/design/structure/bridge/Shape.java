package com.java.practice.design.structure.bridge;

public abstract class Shape {
	protected Color color;

	public Shape(Color color) {
		this.color = color;
	}

	abstract void applyColor();
}
