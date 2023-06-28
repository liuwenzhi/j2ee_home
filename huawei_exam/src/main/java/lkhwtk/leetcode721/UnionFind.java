package lkhwtk.leetcode721;

/**
 * 并查集模板类
 */
public class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * 合并两个节点
     */
    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);
    }

    /**
     * 查找一个节点的代表节点，代表节点的index和parent[index]是同一个值
     */
    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }

}
