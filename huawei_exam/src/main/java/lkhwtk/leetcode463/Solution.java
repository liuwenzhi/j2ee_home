package lkhwtk.leetcode463;

/**
 * 本题配合200题岛屿数量，695题，岛屿最大面积一起看下，同属于岛屿问题
 * 参考题解：图解：在 DFS 遍历过程中求周长（Java）
 * 注意本题特殊的点：求岛屿的周长，核心思路：岛屿的周长就是岛屿方格和非岛屿方格相邻的边的数量
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    //因为只有一个岛屿，只需要计算一次，之后直接跳出循环
                    return dfs(i, j, grid);
                }
            }
        }
        return 0;
    }

    /**
     * 基于深度优先遍历来访问岛屿
     * i和j代表岛屿二维数组横坐标，grid是岛屿二维数组
     */
    private int dfs(int i, int j, int[][] grid) {
        // 从一个岛屿方格走向网格边界，周长加 1
        if (!(0 <= i && i < grid.length && 0 <= j && j < grid[0].length)) {
            //System.out.println("出口1:"+1);
            return 1;
        }
        // 从一个岛屿方格走向水域方格，周长加 1
        if (grid[i][j] == 0) {
            //System.out.println("出口2:"+1);
            return 1;
        }
        //是2代表已经访问过，则返回0
        if (grid[i][j] == 2) {
            //System.out.println("出口3:"+0);
            return 0;
        }
        //设置该方格访问标记为2，已经访问过
        grid[i][j] = 2;
        //访问该方格的上下左右几个临近节点
        return dfs(i + 1, j, grid)+dfs(i - 1, j, grid)+dfs(i, j + 1, grid)+dfs(i, j - 1, grid);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] grid = {{0},{1}};
        System.out.println(solution.islandPerimeter(grid));
    }
}
