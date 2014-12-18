package com.mrcodeninja.unionfind;

/**
 * @author mrcodeninja
 */
public class QuickFind implements UnionFind {
    private int[] ids;

    public QuickFind(int n) {
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return ids[p] == ids[q];
    }

    @Override
    public void union(int p, int q) {
        int pId = ids[p];
        int qId = ids[q];

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pId) {
                ids[i] = qId;
            }
        }
    }
}
