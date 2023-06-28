package lkhwtk.leetcode1631;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1631. 最小体力消耗路径
 * 参考题解：多图详细分析解题思路，分享刷题心得
 * 这个题解的图解好好理解下，实际是采用克鲁斯卡尔算法找到一个图的最短路径
 * 参考题解：官方。参考官方并查集思路，和上边题解说的实际是一个思路。代码按照官方的改
 */
public class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        //建立边集合，每一行元素中包括：起点节点编号，终点节点编号，边的权值
        List<int[]> edges = new ArrayList<int[]>();
        //封装边的思路：设计一个id，这个id通过行列的累加来唯一确认一个节点的编号，然后所有的：
        //不在第一行的节点，都和上一行同列的节点建立一条边（实际是和上方节点建立边）,不在第一列的节点，都和同行左边的节点建立一条边（实际是和左方节点建立边）
        //既不在第一行、又不在第一列的点，同时和上方、左方节点建立边
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int id = i * n + j;
                if (i > 0) {
                    //不在第一行的节点，都和上一行同列的节点建立一条边
                    edges.add(new int[]{id - n, id, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if (j > 0) {
                    //不在第一列的节点，都和同行左边的节点建立一条边
                    edges.add(new int[]{id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }
        //按照权值从小到大排序
        Collections.sort(edges, new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                return edge1[2] - edge2[2];
            }
        });
        //注意：放入并查集中的元素是每一个节点，不是边，并查集主要是判断连通性这块，根据路径能够拿到开始节点，结束节点，然后放入并查集中
        UnionFind uf = new UnionFind(m * n);
        int ans = 0;
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], v = edge[2];
            uf.unite(x, y);
            //如果图的左上角节点和右下角节点能够连通，则得到结果
            if (uf.connected(0, m * n - 1)) {
                //最后合并过来的这条边，肯定是权值最大的，直接返回即可
                ans = v;
                break;
            }
        }
        return ans;

    }
}
