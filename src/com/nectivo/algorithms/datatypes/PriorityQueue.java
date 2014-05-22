package com.nectivo.algorithms.datatypes;

/**
 * Created by piobab on 22.05.2014.
 */
public class PriorityQueue extends BinaryHeap {

    private Comparable[] pq;
    private int N;

    public PriorityQueue(int capacity) {
        pq = new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Add node at the end, then swim it up.
     *
     * @param elem
     */
    public void insert(Comparable elem) {
        pq[++N] = elem;
        swim(N);
    }

    /**
     * Exchange root with node at the end, then sink it down.
     *
     * @return
     */
    public Comparable delateMax() {
        Comparable max = pq[1];
        exch(1, N--);
        sink(1, N);
        pq[N + 1] = null;
        return max;
    }

    @Override
    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    @Override
    public void exch(int i, int j) {
        Comparable temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
