package com.java.practice.design.creational.builder;

public class Computer {
	// required prop
	private String HDD;
	private String RAM;

	// optional prop
	private boolean isGraphicCardEnabled;
	private boolean isBluetoothEnabled;

	public String getHDD() {
		return HDD;
	}

	public String getRAM() {
		return RAM;
	}

	public boolean isGraphicCardEnabled() {
		return isGraphicCardEnabled;
	}

	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}

	private Computer(ComputerBuilder builder) {
		this.HDD = builder.HDD;
		this.RAM = builder.RAM;
		this.isGraphicCardEnabled = builder.isGraphicCardEnabled;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
	}

	@Override
	public String toString() {
		return "Computer [HDD=" + HDD + ", RAM=" + RAM + ", isGraphicCardEnabled=" + isGraphicCardEnabled
				+ ", isBluetoothEnabled=" + isBluetoothEnabled + "]";
	}

	public static class ComputerBuilder {
		// required prop
		private String HDD;
		private String RAM;

		// optional prop
		private boolean isGraphicCardEnabled;
		private boolean isBluetoothEnabled;

		public ComputerBuilder(String hdd, String ram) {
			this.HDD = hdd;
			this.RAM = ram;
		}

		public ComputerBuilder setGraphicCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicCardEnabled = isGraphicsCardEnabled;
			return this;
		}

		public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}

		public Computer build() {
			return new Computer(this);
		}
	}

	public static void main(String[] args) {
		Computer computer = new Computer.ComputerBuilder("500GB", "2GB").setBluetoothEnabled(true)
				.setGraphicCardEnabled(false).build();

		System.out.println(computer);
	}
}
