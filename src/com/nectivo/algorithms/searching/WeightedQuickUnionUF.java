package com.nectivo.algorithms.searching;

/**
 * Created by piobab on 26.03.2014.
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;

    public WeightedQuickUnionUF(int N) {
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
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
        // link root of smaller tree to root of larger tree.
        if(sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
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
