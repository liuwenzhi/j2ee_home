package lkhwtk.leetcode1267;

/**
 * 1267. 统计参与通信的服务器
 * 注意本题的坑点：同一行或者同一列可以通信，不用相互邻近，故本题思路不是深度优先遍历
 */
public class Solution {
    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        // 分别统计每行，每列1的个数，这一步是一个辅助工作，主要是后边双重for循环统计的时候，要保证某行或者某列，至少有两个服务器才能说明连同
        int[] rowArray = new int[row];
        int[] colArray = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //需要同时做行和列的累加
                if (grid[i][j] == 1) {
                    rowArray[i] += 1;
                    colArray[j] += 1;
                }
            }
        }
        // 坐标(i, j) 所在行或列有其它服务器则累加计数
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //核心思路，这一行有了这个元素了，这一列也有了这个元素了，必须要保证还有其他的元素才能形成连接
                if (grid[i][j] != 0 && (rowArray[i] > 1 || colArray[j] > 1)) {
                    count++;
                }
            }
        }
        return count;
    }
}
