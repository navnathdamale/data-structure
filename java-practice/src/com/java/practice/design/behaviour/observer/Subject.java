package com.java.practice.design.behaviour.observer;

public interface Subject {
	void register(Observer obj);

	void unRegister(Observer obj);

	void notifyObservers();

	Object getUpdate(Observer obj);
}
