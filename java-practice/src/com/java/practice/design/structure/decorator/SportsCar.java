package com.java.practice.design.structure.decorator;

public class SportsCar extends CarDecorator {

	public SportsCar(Car car) {
		super(car);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.print(" Adding features of Sports Car.");
	}
}