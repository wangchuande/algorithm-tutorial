package com.algorithm.tutorial.array;

public class ArrayQueue {

    private String[] queue;

    private int capacity;

    private int head;

    private int tail;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        head = tail = 0;
    }


    public boolean enqueue(String item) {
        if (tail == capacity) {
            return false;
        }

        queue[tail] = item;
        tail++;

        return true;
    }

    public String dequeue() {

        if (head == tail) {
            return null;
        }

        String item = queue[head];
        head++;

        return item;
    }
}
