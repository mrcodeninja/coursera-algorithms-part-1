package com.mrcodeninja.unionfind;

/**
 * @author mrcodeninja
 */
public interface UnionFind {
    boolean connected(int p, int q);
    void union(int p, int q);
}
