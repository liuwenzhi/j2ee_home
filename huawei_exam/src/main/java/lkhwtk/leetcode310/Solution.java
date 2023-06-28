package lkhwtk.leetcode310;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 310. 最小高度树
 * 参考题解：最容易理解的bfs，分析简单，注释详细
 * 本题接思路相当巧妙，从外向内，一层一层找，把越往里面的节点作为根节点越有可能是最小高度树
 * 本题建立了无向图的邻接表，1136,207和210题都采用了这种方式，二轮复习时候可以一起看下
 * 备注：本题如果是对每个节点进行bfs，暴力统计路径长度会超时
 */
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        /*如果只有一个节点，那么他就是最小高度树*/
        if (n == 1) {
            res.add(0);
            return res;
        }
        /*建立各个节点的出度表*/
        int[] degree = new int[n];
        /*建立图关系(临街表)，在每个节点的list中存储相连节点，初始化空列表的步骤必不可少*/
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        //注意：因为是无向图，入度和出度都是一个，所以一条边的连接要做两次操作，度数加1，关联关系加1，注意这种遍历二维数组的方式，edges是一个n*2的矩阵
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        /*建立队列*/
        Queue<Integer> queue = new LinkedList<>();
        /*把所有出度为1的节点，也就是叶子节点入队*/
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1){
                queue.offer(i);
            }
        }
        /*循环条件当然是经典的不空判断*/
        while (!queue.isEmpty()) {
            /*这个地方注意，我们每层循环都要new一个新的结果集合，这样最后保存的就是最终的最小高度树根节点值了，因为不知道什么时候是最小的，
            所以只能这么有些冗余的处理下，等到queue队列为null之后，最后一次存放的res就是最终结果，res实际相当于一个临时列表，每次保存度最少的几个节点*/
            res = new ArrayList<>();
            /*获取当前层节点的数量，实际是*/
            int size = queue.size();
            //遍历全部叶子节点，放到res里边（res每次while循环都会重新初始化），然后从邻接矩阵中获取加入到res中节点的全部邻居，度数-1，当是叶子节点的时候再加入到队列中
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                /*把当前节点加入结果集，不要有疑问，为什么当前只是叶子节点为什么要加入结果集呢?
                因为我们每次循环都会新建一个list，所以最后保存的就是最后一个状态下的叶子节点，
                这也是很多题解里面所说的剪掉叶子节点的部分，你可以想象一下图，每层遍历完，
                都会把该层（也就是叶子节点层）这一层从队列中移除掉，
                不就相当于把原来的图给剪掉一圈叶子节点，形成一个缩小的新的图吗*/
                res.add(cur);
                List<Integer> neighbors = map.get(cur);
                /*这里就是经典的bfs了，把当前节点的相邻接点都拿出来，
                 * 把它们的出度都减1，因为当前节点已经不存在了，所以，
                 * 它的相邻节点们就有可能变成叶子节点*/
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        /*如果是叶子节点我们就入队*/
                        queue.offer(neighbor);
                    }
                }
            }
        }
        /*返回最后一次保存的list*/
        return res;
    }
}
