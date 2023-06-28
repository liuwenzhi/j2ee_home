package lkhwtk.leetcode210;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 210. 课程表 II
 * 参考题解：官方，官方视频说明非常好
 * 知识点：拓扑排序，即：有向无环图的排序
 * 图的遍历最长用的算法：通过递归实现的深度优先遍历算法，通过队列实现的广度优先遍历算法
 */
public class Solution {
    /**注意存储有向图的方式：List列表里边套一个list列表，根据题干：现在你总共有 n 门课需要选，记为 0 到 n-1，
     外层列表可以用元素编号来代表前置课程号（正好是0到n-1），每个编号对应的泛型元素是一个列表，存放后置课程集合，
     可以使用一个Map<Integer,List<Integer>>来替代，但是结合题干没有这个方便*/
    List<List<Integer>> edges;
    /**标记每个节点的状态：0=未搜索，1=搜索中，2=已完成，进行深度遍历的时候，如果出现搜索中的节点，则说明存在环*/
    int[] visited;
    /**用数组来模拟栈，下标 n-1 为栈底，0 为栈顶，最终返回的是result，没有单独定义栈，因为要进行入栈和出栈的
     * 操作，最后出栈还得再把值放到一个数组里边，不如直接存一个结果数组，然后存值的之后从后往前存储*/
    int[] result;
    /**判断有向图中是否有环，无环是true，有环是false*/
    boolean valid = true;
    // 栈下标
    int index;

    /**
     * 深度优先遍历，借助栈来实现
     * numCourses：课程数量
     * prerequisites：n*2的二维数组，每行第二个课程是先修课程
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //注意：初始化edges的时候，不能把numCourses作为初始大小去初始化列表
        edges = new ArrayList<List<Integer>>();
        //给有向无环图添加List列表元素
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;
        //将入参中的课程关系保存到edges集合中，形成一个真正的有向五环图，注意二维数组的遍历方式：每次拿取一维数组元素，拿到这个元素之后
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        // 每次挑选一个「未搜索」的节点，开始进行深度优先搜索
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        //存在环，返回一个空数组
        if (!valid) {
            return new int[0];
        }
        // 如果没有环，那么就有拓扑排序
        return result;
    }

    public void dfs(int u) {
        // 将节点标记为「搜索中」
        visited[u] = 1;
        // 搜索其相邻节点
        // 只要发现有环，立刻停止搜索
        for (int v: edges.get(u)) {
            // 如果「未搜索」那么搜索相邻节点
            if (visited[v] == 0) {
                dfs(v);
                //这一步可以去掉，不影响最终结果
                if (!valid) {
                    return;
                }
            }
            // 如果「搜索中」说明找到了环
            else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        // 将节点标记为「已完成」
        visited[u] = 2;
        // 将节点入栈，入栈放入栈底，按照算法，后置课程放在栈底，前置课程放在栈顶，这样做到先修前置课程然后才能修后置课程
        result[index--] = u;
    }

}
