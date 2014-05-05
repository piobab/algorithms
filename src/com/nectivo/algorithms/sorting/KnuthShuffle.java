package com.nectivo.algorithms.sorting;

import java.util.Random;

/**
 * Created by piobab on 05.05.2014.
 */
public class KnuthShuffle {

    public static void shuffle(Comparable[] a) {
        int N = a.length;
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            int r = random.nextInt(i + 1);
            exch(a, i, r);
        }
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
