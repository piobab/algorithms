package com.nectivo.algorithms.datatypes;

/**
 * Created by piobab on 22.05.2014.
 * <p/>
 * Binary tree representation is made with array.
 * Largest key is a[1], which is root of binary tree.
 * Parent of node at k is at k/2.
 * Children of node at k are at 2k and 2k+1.
 */
public abstract class BinaryHeap {

    /**
     * Method uses during key insertion to guarantee that heap is ordered.
     * Scenario: child's key become larger key than its parent's key.
     * Exchange key in child with key in parent.
     * Repeat until heap order restored.
     *
     * @param k
     */
    public void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    /**
     * Method uses during max key deletion from the root of the tree.
     * Scenario: parent's key become smaller key than one (or both) of its children's.
     * Exchange key in parent with key in larger child.
     * Repeat until heap order restored.
     *
     * @param k
     * @param n - number of elements
     */
    public void sink(int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }

            if (!less(k, j)) {
                break;
            }

            exch(k, j);
            k = j;
        }
    }

    public abstract boolean less(int i, int j);

    public abstract void exch(int i, int j);
}
