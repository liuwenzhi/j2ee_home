package lkhwtk.offer47;

/**
 * 参考题解：官方。
 * 对Solution的一个简单的优化，把第一行，第一例拿出来，单独户初始化为grid原始记录以及累加，不涉及逻辑判断。
 * 然后在二重for循环中处理设计逻辑判断的内容,
 */
public class Solution1 {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int j = 1; j < n; j++) { // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        }
        for(int i = 1; i < m; i++) { // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        }
        for(int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
