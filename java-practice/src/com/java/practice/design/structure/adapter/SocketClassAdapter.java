package com.java.practice.design.structure.adapter;

public class SocketClassAdapter extends Socket implements SocketAdapter {

	@Override
	public Volt get120Volt() {
		return getVolt();
	}

	@Override
	public Volt get12Volt() {
		return convertVolt(getVolt(), 10);
	}

	@Override
	public Volt get3Volt() {

		return convertVolt(getVolt(), 40);
	}

	private Volt convertVolt(Volt volt, int factor) {
		return new Volt(volt.getVolt() / factor);
	}

	public static void main(String[] args) {
		SocketClassAdapter socketClassAdapter = new SocketClassAdapter();
		Volt v3 = socketClassAdapter.get3Volt();
		System.out.println("v3 volts using Object Adapter=" + v3.getVolt());
	}
}
