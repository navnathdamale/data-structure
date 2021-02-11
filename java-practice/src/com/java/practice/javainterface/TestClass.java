package com.java.practice.javainterface;

public class TestClass implements Interface1, Interface2 {

	public static void main(String[] args) {
		Interface1 interface1 = new TestClass();
		interface1.log1();

		Interface2 interface2 = new TestClass();
		interface2.log2();

		Interface1 m1 = () -> System.out.println("Test ");
		m1.m1();
		
		m1 = () -> System.out.println("Test1 ");
		m1.m1();
	}

	@Override
	public void m1() {
		// TODO Auto-generated method stub

	}

	@Override
	public void m2() {

	}
}
