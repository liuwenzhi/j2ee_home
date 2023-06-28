package lkhwtk.mst0401;

/**
 * 面试题 04.01. 节点间通路
 * 参考题解：【🎉祝各位offer多多】DFS，附详细注释
 * 核心思路：深度遍历递归算法+回溯
 */
public class Solution {
    /**创建有向图的路径访问状态数组*/
    private boolean[] visited = null;
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 创建访问状态数组
        this.visited = new boolean[graph.length];
        return dfs(graph, start, target);
    }

    /**
     * 深度优先遍历有向图
     */
    private boolean dfs(int[][] graph, int start, int target) {
        for (int i = 0; i < graph.length; ++i) {
            // 确保当前路径未被访问（该判断主要是为了防止图中自环出现死循环的情况）
            if (!visited[i]) {
                // 若当前路径起点与终点相符，则直接返回结果
                if (graph[i][0] == start && graph[i][1] == target) {
                    return true;
                }
                // 设置访问标志
                visited[i] = true;
                // DFS关键代码，思路：同时逐渐压缩搜索区间，固定结束位置，然后让开始位置一层一层去过滤
                //当前路径的结束为止节点是target，同时通过start节点能到达当前路径的开始节点
                if (graph[i][1] == target && dfs(graph, start, graph[i][0])) {
                    return true;
                }
                // 清除访问标志
                visited[i] = false;
            }
        }
        return false;
    }

}
