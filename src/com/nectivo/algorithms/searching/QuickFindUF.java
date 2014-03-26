package com.nectivo.algorithms.searching;

/**
 * Created by piobab on 26.03.2014.
 *
 * This algorithm is N^2
 */
public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        // set id of each object to itself (N array accesses)
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * Check whether p and q are in the same component (2 array accesses).
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        // change all entries with id[p] to id[q] (at most 2N + 2 array accesses)
        for(int i = 0; i < id.length; i++) {
            if(id[i] == pid) {
                id[i] = qid;
            }
        }
    }
}
