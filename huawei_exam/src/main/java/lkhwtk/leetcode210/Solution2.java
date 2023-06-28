package lkhwtk.leetcode210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 采用拓扑排序的思路
 */
public class Solution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //返回结果数组和下标
        int[] result = new int[numCourses];
        int index = 0;
        //ArrayList数组存储课程关系
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        //数组中元素从1到n创建一个ArrayList
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        //添加课程关系
        for (int i = 0; i < prerequisites.length; i++) {
            int v1 = prerequisites[i][1];
            int v2 = prerequisites[i][0];
            adj[v1].add(v2);
        }
        //节点入度数组，相当于统计每一门课程的先修课程数量
        int[] inDegree = new int[numCourses];
        //遍历课程关系列表数组，找到i课程的全部后置课程列表，然后拿到列表中的每一个课程（节点），进行入度统计
        for (int i = 0; i < numCourses; i++) {
            ArrayList<Integer> neighbors = adj[i];
            for (int j = 0; j < neighbors.size(); j++) {
                int neighbor = neighbors.get(j);
                inDegree[neighbor]++;
            }
        }
        //建立遍历队列，将入度为0的节点放到队列末尾，算法从始至终都是用queue保存入度为0的课程节点
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                //入队使用offer，addLast，add都可以
                queue.offer(i);
            }
        }
        //没有能够开始的情况
        if (queue.isEmpty()) {
            // 没有入度为0的
            return new int[0];
        }
        //返回结果
        //int ans = 0;
        //剩余要统计节点的数量
        int leftNodeCount = numCourses;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                //在list列表中添加队头元素，也可以使用removeFirst
                list.add(queue.poll());
            }
            //剩余节点数=总数-入度为0的课程节点
            leftNodeCount -= list.size();
            //ans自增，学完了开始的全部的没有前置课程的课程
            //ans++;
            //第一波前置课程学习完成之后，更新临接表，临时list列表中保存了全部入读为0的节点，在这里，需要重新统计列表中每个节点的后置节点的入度，减去1
            for (int i = 0; i < list.size(); i++) {
                //每次循环拿出入度为0的节点，保存到结果数组中
                int v = list.get(i);
                result[index++] = v;
                //获取该节点的临接列表
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
        return leftNodeCount > 0 ? new int[0] : result;
    }
}
