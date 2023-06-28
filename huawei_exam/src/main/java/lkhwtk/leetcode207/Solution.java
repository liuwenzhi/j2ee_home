package lkhwtk.leetcode207;

import java.util.ArrayList;
import java.util.List;

/**
 * 207. 课程表
 * 本题比210题稍微简单一点，参考210题思路整理本题代码
 */
public class Solution {
    /**注意存储有向图的方式：List列表里边套一个list列表，根据题干：现在你总共有 n 门课需要选，记为 0 到 n-1，
     外层列表可以用元素编号来代表前置课程号（正好是0到n-1），每个编号对应的泛型元素是一个列表，存放后置课程集合，
     可以使用一个Map<Integer,List<Integer>>来替代，但是结合题干没有这个方便*/
    List<List<Integer>> edges;
    /**标记每个节点的状态：0=未搜索，1=搜索中，2=已完成，进行深度遍历的时候，如果出现搜索中的节点，则说明存在环*/
    int[] visited;
    /**判断有向图中是否有环，无环是true，有环是false*/
    boolean valid = true;

    /**
     * 深度优先遍历，借助栈来实现
     * numCourses：课程数量
     * prerequisites：n*2的二维数组，每行第二个课程是先修课程
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //注意：初始化edges的时候，不能把numCourses作为初始大小去初始化列表
        edges = new ArrayList<List<Integer>>();
        //给有向无环图添加List列表元素
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        //将入参中的课程关系保存到edges集合中，形成一个真正的有向无环图，注意二维数组的遍历方式：每次拿取一维数组元素，然后从一维数组中拿存在前后关系的两个元素
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        // 每次挑选一个「未搜索」的节点，开始进行深度优先搜索
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        //存在环，返回false，课程学不完
        if (!valid) {
            return false;
        }
        //如果没有环，同时全部节点都被访问到，则返回true
        for(int v:visited){
            if(v!=2){
                return false;
            }
        }
        return true;
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
    }
}
