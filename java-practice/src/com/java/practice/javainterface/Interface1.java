package com.java.practice.javainterface;

@FunctionalInterface
public interface Interface1 {
	void m1();

	default void log1() {
		System.out.println("Interface1 default method");
	}

	static void print() {
		System.out.println("static method Interface1");
	}
}
