package com.mrcodeninja.unionfind;

/**
 * @author mrcodeninja
 */
public class QuickUnion implements UnionFind {
    private int[] parentOf;

    public QuickUnion(int n) {
        parentOf = new int[n];
        for (int i = 0; i < n; i++) {
            parentOf[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return rootOf(p) == rootOf(q);
    }

    @Override
    public void union(int p, int q) {
        int rootOfP = rootOf(p);
        int rootOfQ = rootOf(q);

        parentOf[rootOfP] = rootOfQ;
    }

    private int rootOf(int i) {
        while (i != parentOf[i]) {
            i = parentOf[i];
        }

        return i;
    }
}
