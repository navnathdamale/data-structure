package com.java.practice.design.behaviour.momento;

public class MomentoCareTaker {
	private Object momento;

	public void save(MomentoOriginator momentoOriginator) {
		this.momento = momentoOriginator.save();
	}

	public void undo(MomentoOriginator momentoOriginator) {
		if (this.momento != null) {
			momentoOriginator.undoToLastSaved(this.momento);
		}
	}

	public static void main(String[] args) {
		MomentoCareTaker momentoCareTaker = new MomentoCareTaker();
		MomentoOriginator fileOne = new MomentoOriginator("fileOne.txt");
		fileOne.write("Writing into file one");
		momentoCareTaker.save(fileOne);
		System.out.println(fileOne);

		MomentoOriginator fileTwo = new MomentoOriginator("fileTwo.txt");
		fileTwo.write("Writing into file two");
		fileTwo.save();
		momentoCareTaker.undo(fileTwo);
		System.out.println(fileTwo);
	}
}