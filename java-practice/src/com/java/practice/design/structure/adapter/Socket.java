package com.java.practice.design.structure.adapter;

public class Socket {
	public Volt getVolt() {
		return new Volt(120);
	}
}
