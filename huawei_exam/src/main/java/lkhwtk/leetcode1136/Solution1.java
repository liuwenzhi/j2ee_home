package lkhwtk.leetcode1136;

import java.util.ArrayList;
import java.util.List;

/**
 * 1136. 平行课程
 * 本题和207题，210题思路类似，注意本题中课程的先修关系，本题每一个relations中的数据，
 * 0是先修，1是后修，207题和210题中1是先修，0是后修，然后本题课程以1到N进行编号
 * 个人思路：跑完51%的测试用例。
 * 2021年9月4日二轮刷题总结：本题求的是最短学期，本题采用深度优先遍历的思路，找到每一个课程链的完整学习时间，
 * 然后拿出一个最大的时间，这个思路从根本上没有大的错误，但是会有遗漏，其实207题和210题应该是测试用例有遗漏。
 * 问题点在于：基于深度优先遍历算法，比如一门课程，它既有前置课程，也是其他课程的前置课程，基于深度优先遍历
 * 算法可以直接基于这门课程进行遍历，在没有修完它的前置课程的时候就可以。基于拓扑排序通过入度为0的点进行遍历，
 * 就解决了这个问题。
 */
public class Solution1 {

    /**注意存储有向图的方式：List列表里边套一个list列表，根据题干：现在你总共有 n 门课需要选，记为 0 到 n-1，
     外层列表可以用元素编号来代表前置课程号（正好是0到n-1），每个编号对应的泛型元素是一个列表，存放后置课程集合，
     可以使用一个Map<Integer,List<Integer>>来替代，但是结合题干没有这个方便*/
    List<List<Integer>> edges;

    /**标记每个节点的状态：0=未搜索，1=搜索中，2=已完成，进行深度遍历的时候，如果出现搜索中的节点，则说明存在环*/
    int[] visited;

    /**判断有向图中是否有环，无环是true，有环是false*/
    boolean valid = true;

    /**最终返回结果*/
    int result = 0;

    public int minimumSemesters(int n, int[][] relations) {

        //注意：初始化edges的时候，不能把numCourses作为初始大小去初始化列表
        edges = new ArrayList<>();
        //给有向无环图添加List列表元素，存储课程的时候有一点点变化，以课程编号-1来记录课程N
        for (int i = 0; i < n; ++i) {
            edges.add(new ArrayList<>());
        }
        visited = new int[n];
        //将入参中的课程关系保存到edges集合中，形成一个真正的有向无环图，注意二维数组的遍历方式：每次拿取一维数组元素，然后从一维数组中拿存在前后关系的两个元素
        for (int[] info : relations) {
            edges.get(info[0]-1).add(info[1]-1);
        }
        // 每次挑选一个「未搜索」的节点，开始进行深度优先搜索
        for (int i = 0; i < n && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i,1);
            }
        }
        //存在环，返回-1，课程学不完
        if (!valid) {
            return -1;
        }
        return result;
    }

    /**
     * 深度优先遍历图，做一点改动，增加下递归深度参数
     */
    public void dfs(int u,int level) {
        result = Math.max(result,level);
        // 将节点标记为「搜索中」
        visited[u] = 1;
        // 搜索其相邻节点
        // 只要发现有环，立刻停止搜索
        for (int v: edges.get(u)) {
            // 如果「未搜索」那么搜索相邻节点
            if (visited[v] == 0) {
                level++;
                dfs(v,level);
                level--;
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
