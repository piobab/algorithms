package com.nectivo.algorithms.searching;

/**
 * Created by piobab on 26.03.2014.
 */
public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        // check if p and q have same root
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        // change root of p to point root of q (depth of p and q array access).
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    /**
     * Chase parent pointers until reach root (depth of i array accesses)
     * @param i
     * @return
     */
    private int root(int i) {
        while(i != id[i]) {
            i = id[i];
        }
        return i;
    }
}
