package lkhwtk.leetcode684;

/**
 * 684. 冗余连接
 * 本题基于深度优先遍历能够找到环，类似210题和207题，但是不太好找出具体要去掉的边。
 * 更适合用并查集来做。并查集的基本概念参考题解：通俗讲解并查集，帮助小白快速理解
 * 本题算法代码来自官方题解，可以配合上边题解来看，该代码可以作为并查集合的模板来使用
 */
public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int nodesCount = edges.length;
        //代表集合设置长度为nodesCount+1，主要是节点的编号是1,2,3,4,5等等，节点编号直接和数组下标编号能直接匹配上
        //然后数组中存在的是编号为i的节点的代表节点（集合代表节点），也是1,2,3,4,5这个编号。保留一个0，作为占位不用多管
        int[] parent = new int[nodesCount + 1];
        //parent数组，从1开始赋值，i代表节点编号，这里可参考题干中说明：N个节点 (节点值不重复1, 2, ..., N)
        for (int i = 1; i <= nodesCount; i++) {
            //先把当前节点的代表节点设置为自己
            parent[i] = i;
        }
        for (int i = 0; i < nodesCount; i++) {
            //每一个edge数组是一个包含两个节点的集合
            int[] edge = edges[i];
            //获取一个数组中比如[1,3]的两个元素：node1 = 1，node2 = 3
            int node1 = edge[0], node2 = edge[1];
            //寻找node1和node2的代表节点，如果集合的代表节点不同，则对这两个集合进行合并
            if (find(parent, node1) != find(parent, node2)) {
                //合并方式为将1的代表节点设置为3的代表节点
                union(parent, node1, node2);
            } else {
                //如果出现了共同的代表节点，那么最后加入的这个边就是
                return edge;
            }
        }
        //没有满足条件的集合返回一个空数组
        return new int[0];
    }

    /**
     * 合并parent集合中的两个节点集合，比如边为[1,3]，那么设置3为1的代表节点
     * 具体算法可参考题解：并查集的基本概念参考题解：通俗讲解并查集，帮助小白快速理解
     */
    public void union(int[] parent, int index1, int index2) {
        //找到index1的代表节点，然后将parent数组中这个代表节点的值设置为index2的代表节点
        parent[find(parent, index1)] = find(parent, index2);
    }

    /**
     * 核心内容：查找代表节点，这里实际是找到对于每一个节点的集合节点，
     * 如果当前节点的代表节点不是当前节点本身，那么就要一层一层递归寻找最根上的代表节点
     * 在递归的最后一层，发现parent[index]=index了，再返回最后一层的这个代表节点，一层一
     * 层返回之后，最终赋值给了最开始执行递归的这个parent[index]
     */
    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

}
