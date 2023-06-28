package lkhwtk.leetcode695;

/**
 * 695. 岛屿的最大面积
 * 思路图的DFS遍历算法，本题和200题思路几乎一样
 * 个人针对于Solution1的优化，按照上下左右的顺序递归，效率能稍微高一点
 */
public class Solution1_1 {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int cur_i, int cur_j) {
        if (cur_i < 0 || cur_j < 0 || cur_i >= grid.length || cur_j >= grid[0].length || grid[cur_i][cur_j] != 1) {
            return 0;
        }
        //访问过的点标记为0
        grid[cur_i][cur_j] = 0;
        int ans = 1;
        //深度优先遍历节点上下左右四个点，这样递归效率更高
        ans += dfs(grid, cur_i-1, cur_j);
        ans += dfs(grid, cur_i+1, cur_j);
        ans += dfs(grid, cur_i, cur_j-1);
        ans += dfs(grid, cur_i, cur_j+1);
        return ans;
    }
}
