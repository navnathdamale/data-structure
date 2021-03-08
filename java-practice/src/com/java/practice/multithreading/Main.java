package com.java.practice.multithreading;

public class Main {
    public static void main(String[] args) {

        //BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        //MyBlockingQueueUsingLock<String> queue = new MyBlockingQueueUsingLock(10);
        MyBlockingQueueUsingObject<String> queue = new MyBlockingQueueUsingObject(10);

        final Runnable producer = () -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    queue.put("Added by" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(producer, "Producer Thread:" + i).start();
        }

        final Runnable consumer = () -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Consumed " + queue.take());
                } catch (InterruptedException e) {
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(consumer, "Consumer Thread:" + i).start();
        }
    }
}
