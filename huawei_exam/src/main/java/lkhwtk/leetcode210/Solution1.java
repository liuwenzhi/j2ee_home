package lkhwtk.leetcode210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先遍历思路，从计算每个节点入度和出度角度解决有向无环图遍历问题，参考官方解析和视频说明
 * Queue 中 add() 和 offer()都是用来向队列添加一个元素。
 * 在容量已满的情况下，add() 方法会抛出IllegalStateException异常，offer() 方法只会返回 false 。
 */
public class Solution1 {
    // 存储有向图
    List<List<Integer>> edges;
    // 存储每个节点的入度
    int[] indeg;
    // 存储答案
    int[] result;
    // 答案下标
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        result = new int[numCourses];
        index = 0;
        //将输入的课程关系二维数组维护成有向无环图
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            //后置课程info[0]入度+1
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        // 将所有入度为 0 的节点放入队列中
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                //offer也是从队列尾部放入元素，和add方法的区别参考main方法
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            //从队首取出一个节点
            int u = queue.poll();
            //放入答案中
            result[index++] = u;
            //从有向无环图中遍历后置节点，减小入度值，放入队列
            for (int v: edges.get(u)) {
                --indeg[v];
                // 如果相邻节点 v 的入度为 0，就可以选 v 进入队列
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        //如果图中有环，比如输入 [1,0],[0,1]，此时queue队列中根本没有放入元素，同时while循环也没执行，
        //此时没有一个入度为0的节点，只要途中存在环，就会出现遍历result数组没存满的情况
        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }

    public static void main(String[] args){
        int[] a = new int[10];
        for(int i:a){
            //输出：0 0 0 0 0 0 0 0 0 0
            System.out.print(i+" ");
        }
        System.out.println();
        //自增数组中元素的方式，之前没这么用过
        ++a[0];
        ++a[1];
        for(int i:a){
            //输出：1 1 0 0 0 0 0 0 0 0
            System.out.print(i+" ");
        }
    }

}
