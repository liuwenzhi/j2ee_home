package lkhwtk.leetcode695;

/**
 * 695. 岛屿的最大面积
 * 参考解法：Java标准DFS解法，100%，无全局变量。简洁易懂。
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }
    // 每次调用的时候默认num为1，进入后判断如果不是岛屿，则直接返回0，就可以避免预防错误的情况。
    // 每次找到岛屿，则直接把找到的岛屿改成0，这是传说中的沉岛思想，就是遇到岛屿就把他和周围的全部沉默。
    // ps：如果能用沉岛思想，那么自然可以用朋友圈思想。有兴趣的朋友可以去尝试。
    private int dfs(int i, int j, int[][] grid) {
        //递归出口：如果超过边界，或者是不是岛屿（值为0）则直接返回0
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        //沉岛，避免递归过程中重复遍历同一个岛屿位置，也避免主方法中二层for循环重复遍已经在递归方法中遍历过的岛屿
        grid[i][j] = 0;
        //记录当前岛屿面积值为1
        int num = 1;
        //从沉岛的上下左右四个方向进行统计
        num += dfs(i + 1, j, grid);
        num += dfs(i - 1, j, grid);
        num += dfs(i, j + 1, grid);
        num += dfs(i, j - 1, grid);
        return num;

    }

}
