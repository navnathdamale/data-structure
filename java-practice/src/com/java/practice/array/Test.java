package com.java.practice.array;

public class Test {
	public static void main(String[] args) {
		FloatValidator floatValidator = new FloatValidator("test");
		System.out.println(floatValidator.getFloat());
		System.out.println(floatValidator.getFloat());
	}
}

class FloatValidator {
	private String f;

	public FloatValidator(String f) {
		this.f = f;
	}

	public String getFloat() {
		return f;
	}
}