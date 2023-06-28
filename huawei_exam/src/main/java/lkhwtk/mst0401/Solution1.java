package lkhwtk.mst0401;

/**
 * 核心递归思路使用了和Solution相反的想法，固定开始位置，递归寻找结束位置，在服务器上跑完了部分用例，结果超时了。
 * 一共32个用例，通过了31个，最后一个10000个节点，边数极大的测试用例没通过，超时了
 */
public class Solution1 {
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
                if (graph[i][0] == start && dfs(graph, graph[i][1], target)) {
                    return true;
                }
                // 清除访问标志
                visited[i] = false;
            }
        }
        return false;
    }
}
