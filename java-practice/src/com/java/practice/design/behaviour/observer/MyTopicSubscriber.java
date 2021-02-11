package com.java.practice.design.behaviour.observer;

public class MyTopicSubscriber implements Observer {
	private String name;
	private Subject topic;

	public MyTopicSubscriber(String name) {
		this.name = name;
	}

	@Override
	public void update() {
		String msg = (String) topic.getUpdate(this);
		if (msg == null) {
			System.out.println(name + ":: No new message");
		} else
			System.out.println(name + ":: Consuming message::" + msg);
	}

	@Override
	public void setSubject(Subject sub) {
		this.topic = sub;
	}

	public static void main(String[] args) {
		// create subject
		MyTopic topic = new MyTopic();

		// create observers
		Observer obj1 = new MyTopicSubscriber("Obj1");
		Observer obj2 = new MyTopicSubscriber("Obj2");
		Observer obj3 = new MyTopicSubscriber("Obj3");

		// register observers to the subject
		topic.register(obj1);
		topic.register(obj2);
		topic.register(obj3);

		// attach observer to subject
		obj1.setSubject(topic);
		obj2.setSubject(topic);
		obj3.setSubject(topic);

		// check if any update is available
		obj1.update();

		// now send message to subject
		topic.postMessage("New Message");
	}

}
