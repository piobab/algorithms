package com.nectivo.algorithms.datatypes;

/**
 * Created by piobab on 08.02.2014.
 *
 * Stack: array implementation.
 */
public class FixedCapacityStackOfStrings {
    private String[] s;
    private int N;

    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        s[N++] = item;
    }

    public String pop() {
        String item = s[--N];
        s[N] = null;
        return item;
    }
}
