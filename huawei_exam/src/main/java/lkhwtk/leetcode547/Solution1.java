package lkhwtk.leetcode547;

/**
 * 并查集实现方案，将属于同一个连通分量的节点关联到同一个代表节点上.
 * 连通分量相关题目可以参考使用并查集来解决
 */
public class Solution1 {
    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        //parent数组是全部节点的代表节点数组，初始化为节点本身
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                //如果两个节点是连接的，则在parent数组中合并这两个节点
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int circles = 0;
        //注意通过并查集找根节点的方式：当当前节点的代表节点和当前节点是同一个值的时候，可以确定一个连通分量的代表节点
        //该连通分量中有很多其他节点，代表节点都指向了当前的节点，同属于同一个省份，这里找连通分量直接找根节点，条件是：parent[i] == i
        for (int i = 0; i < provinces; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    /**
     * 并查集合并两个节点，在parent数组中将index1的代表节点设置为index2的代表节点
     * 或者将index2的代表节点设置为index1的代表节点
     */
    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    /**
     * 核心内容：查找代表节点，这里实际是找到对于每一个节点的集合节点，
     * 如果当前节点的代表节点不是当前节点本身，那么就要一层一层递归寻找最根上的代表节点
     * 在递归的最后一层，发现parent[index]=index了，再返回最后一层的这个代表节点，一层一
     * 层返回之后，最终赋值给了最开始执行递归的这个parent[index]，注意这里的条件是if判断
     * 执行递归，不是while判断执行递归，递归最终结束之后，返回的结果parent[index]肯定是不
     * 等于index的，如果没有执行递归，那么当前节点的代表节点就是当前节点本身，这个时候parent[index] = index
     */
    public int find(int[] parent, int index) {
        //如果代表节点不是节点本身，则继续递归寻找代表节点的代表节点
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

}
