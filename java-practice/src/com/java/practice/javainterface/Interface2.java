package com.java.practice.javainterface;

@FunctionalInterface
public interface Interface2 {
	void m2();

	default void log2() {
		System.out.println("Interface2 default method");
	}

	static void print() {
		System.out.println("static method Interface2");
	}
}
