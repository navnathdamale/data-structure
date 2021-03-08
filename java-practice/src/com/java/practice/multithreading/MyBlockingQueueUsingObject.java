package com.java.practice.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueueUsingObject<E> {
    private Queue<E> queue;
    private int max = 16;

    public MyBlockingQueueUsingObject(int max) {
        this.queue = new LinkedList<>();
        this.max = max;
    }

    public void put(E e) {
        try {
            synchronized (queue) {
                while (queue.size() == max) {
                    queue.wait();
                }

                queue.add(e);
                queue.notify();
            }
        } catch (InterruptedException ex) {
        }
    }

    public E take() {
        try {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    queue.wait();
                }

                E item = queue.remove();
                queue.notify();
                return item;
            }
        } catch (InterruptedException | IllegalMonitorStateException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}