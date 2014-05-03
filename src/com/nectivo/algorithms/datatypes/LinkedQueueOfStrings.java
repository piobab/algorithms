package com.nectivo.algorithms.datatypes;

/**
 * Created by piobab on 03.05.2014.
 */
public class LinkedQueueOfStrings {
    private Node first, last;

    private class Node {
        String item;
        Node next;
    }

    public void enqueue(String item) {
        // insert at end of linked list
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public String dequeue() {
        // remove from front of linked list
        String item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
