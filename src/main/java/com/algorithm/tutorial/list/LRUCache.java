package com.algorithm.tutorial.list;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Node head;
    private Node tail;
    private int count;
    private int capacity;

    private Map<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }


    public int get(int key) {
        Node node = cache.get(key);

        if (node == null) {
            return -1;
        }
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node == null) {
            if (count == capacity) {
                Node last = removeTail();
                cache.remove(last.key);
                count--;
            }
            Node newNode = new Node(key, value);
            addToHead(newNode);
            cache.put(newNode.key, newNode);
            count++;
            return;
        }

        node.value = value;
        moveToHead(node);
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        Node afterHead = head.next;
        afterHead.pre = node;
        head.next = node;

        node.next = afterHead;
        node.pre = head;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private Node removeTail() {
        Node node = tail.pre;
        removeNode(node);
        return node;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }

}

class Node {
    public int key;
    public int value;
    public Node pre;
    public Node next;

    public Node() {
        this.key = 0;
        this.value = 0;
        this.next = null;
        this.pre = null;
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.pre = null;
    }
}