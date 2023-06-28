package lkhwtk.leetcode1136;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1136. 平行课程
 * 参考题解：官方，看文字说明，官方说明部分深度序列有问题，必须学完6才能学习5
 * 参考题解：java 拓扑排序
 */
public class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        //ArrayList数组存储课程关系，因为本题课程编号是从1开始的，这里建一个队里长度是n+1,0这个位置不使用，还是类似207和210题目的思路，数组中编号代表课程编号
        //本题用数组套列表，实际是java实现的临街表的数据结构
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        //数组中元素从1到n创建一个ArrayList
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        //添加课程关系
        for (int i = 0; i < relations.length; i++) {
            int v1 = relations[i][0];
            int v2 = relations[i][1];
            adj[v1].add(v2);
        }
        //节点入度数组，相当于统计每一门课程的先修课程数量，同样也是0这个位置不管
        int[] inDegree = new int[n + 1];
        //遍历课程关系列表数组，找到i课程的全部后置课程列表，然后拿到列表中的每一个课程（节点），进行入度统计
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> neighbors = adj[i];
            for (int j = 0; j < neighbors.size(); j++) {
                int neighbor = neighbors.get(j);
                inDegree[neighbor]++;
            }
        }
        //建立遍历队列，将入度为0的节点放到队列末尾，算法从始至终都是用queue保存入度为0的课程节点
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                //入队使用offer，addLast，add都可以
                queue.offer(i);
            }
        }
        //没有入度为0的节点，即课程存在循环依赖的情况
        if (queue.isEmpty()) {
            // 没有入度为0的
            return -1;
        }
        //返回结果
        int ans = 0;
        //剩余要统计节点的数量
        int leftNodeCount = n;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                //在list列表中添加队头元素，也可以使用removeFirst，这一层循环把queue中入度为0的节点都弹出来
                list.add(queue.poll());
            }
            //剩余节点数=总数-入度为0的课程节点
            leftNodeCount -= list.size();
            //ans自增，学完了开始的全部的没有前置课程的课程（之前已经在queue队列中把入度为0的节点都弹出来了）
            ans++;
            //第一波前置课程学习完成之后，更新临接表，临时list列表中保存了全部入读为0的节点，在这里，需要重新统计列表中每个节点的后置节点的入度，减去1
            for (int i = 0; i < list.size(); i++) {
                int v = list.get(i);
                //获取该节点的临接列表，全部节点的入度都-1，如果出现了入度为0，则添加到queue队列中，接下来继续走最外层的for循环
                ArrayList<Integer> neighbors = adj[v];
                for (int j = 0; j < neighbors.size(); j++) {
                    int neighbor = neighbors.get(j);
                    //列表中每个元素入度-1
                    inDegree[neighbor]--;
                    //如果入度为0，则添加到queue队列中，
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        //还有剩余课程没学完，代表课程结束不了，返回-1，否则返回学期数
        return leftNodeCount > 0 ? -1 : ans;
    }

}
