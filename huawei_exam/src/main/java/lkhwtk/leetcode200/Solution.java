package lkhwtk.leetcode200;

/**
 * 200. 岛屿数量
 * 200和695、547题一起看下，都属于图的DFS，BFS以及并查集
 * 参考题解：岛屿数量 官方
 * 本题重点看深度优先搜索：进行深度优先搜索的次数就是实际岛屿的数量
 * 本题使用深度优先遍历思路最简单
 * 参考题解：岛屿类问题的通用解法、DFS 遍历框架 精选
 * 该题解对图的深度优先遍历说明非常清晰
 */
public class Solution {
    /**
     * 深度搜索递归方法
     */
    void dfs(char[][] grid, int r, int c) {
        //获取二维数组行数
        int nr = grid.length;
        //获取二维数组列数
        int nc = grid[0].length;
        //行列超过边界，或者是0就停止访问，一次深度优先遍历执行结束，岛屿数量+1
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        //访问到数组中一个点，就将该值标记为0，已经访问过，进行沉岛
        grid[r][c] = '0';
        //深度遍历该节点的上下左右四个点
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                //每次找到一个1，增加一次岛屿数量，然后将这个1能访问到的岛都沉掉
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }

    public static void main(String[] args){
        char[][] grid = {
                {'1','1','1'},
                {'0','1','0'},
                {'1','0','1'}};
        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid));
        //这里验证下grid数组中1都变成0了
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
