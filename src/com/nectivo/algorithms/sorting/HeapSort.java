package com.nectivo.algorithms.sorting;

/**
 * Created by piobab on 22.05.2014.
 * <p/>
 * Repeatedly delete the largest remaining item.
 */
public class HeapSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        // First pass: build heap using bottom-up method.
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }

        // Second pass: remove maximum, one at a time.
        while (N > 1) {
            exch(a, 1, N);
            sink(a, 1, --N);
        }
    }

    /**
     * Method uses during key insertion to guarantee that heap is ordered.
     * Scenario: child's key become larger key than its parent's key.
     * Exchange key in child with key in parent.
     * Repeat until heap order restored.
     *
     * @param a
     * @param k
     */
    public static void swim(Comparable[] a, int k) {
        while (k > 1 && less(a, k / 2, k)) {
            exch(a, k, k / 2);
            k = k / 2;
        }
    }

    /**
     * Method uses during max key deletion from the root of the tree.
     * Scenario: parent's key become smaller key than one (or both) of its children's.
     * Exchange key in parent with key in larger child.
     * Repeat until heap order restored.
     *
     * @param a
     * @param k
     * @param n - number of elements
     */
    public static void sink(Comparable[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1)) {
                j++;
            }

            if (!less(a, k, j)) {
                break;
            }

            exch(a, k, j);
            k = j;
        }
    }

    public static boolean less(Comparable[] a, int i, int j) {
        // Convert from 1-based indexing to 0-base indexing
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = swap;
    }
}
