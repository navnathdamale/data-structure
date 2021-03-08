package com.java.practice.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueueUsingLock<E> {
    private Queue<E> queue;
    private int max = 16;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public MyBlockingQueueUsingLock(int max) {

        this.queue = new LinkedList<>();
        this.max = max;
    }

    public void put(E e) {
        lock.lock();
        try {
            while (queue.size() == max) {
                notEmpty.await();
            }
            queue.add(e);
            notFull.signal();
        } catch (InterruptedException | IllegalMonitorStateException ex) {
            ex.printStackTrace();

        } finally {
            lock.unlock();
        }
    }

    public E take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notFull.await();
            }
            E item = queue.remove();
            notEmpty.signal();
            return item;
        } catch (InterruptedException | IllegalMonitorStateException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }

        return null;
    }
}