package com.mrcodeninja.unionfind;

/**
 * @author mrcodeninja
 */
public class WeightedQuickUnion implements UnionFind {
    private int[] parentOf;
    private int[] sizeAtRoot;

    public WeightedQuickUnion(int n) {
        parentOf = new int[n];
        sizeAtRoot = new int[n];

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

        if (rootOfP == rootOfQ) {
            return;
        }

        if (sizeAtRoot[rootOfP] < sizeAtRoot[rootOfQ]) {
            parentOf[rootOfP] = rootOfQ;
            sizeAtRoot[rootOfQ] += sizeAtRoot[rootOfP];
        } else {
            parentOf[rootOfQ] = rootOfP;
            sizeAtRoot[rootOfP] += sizeAtRoot[rootOfQ];
        }
        parentOf[rootOfP] = rootOfQ;
    }

    private int rootOf(int i) {
        while (i != parentOf[i]) {
            i = parentOf[i];
        }

        return i;
    }
}
