package lkhwtk.mst0802;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 对Solution的优化
 * 参考题解：迷路的机器人，注释详细，朴素思路
 * 注意本题和leetcoe63题的区别，本题是把路径打印出来，63题是统计路径多少，用动态规划直接搞定
 */
public class Solution {
    List<List<Integer>> path = new LinkedList<>();  // 记录路径
    int r = 0;  // 行数
    int c = 0;  // 列数
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        r = obstacleGrid.length;
        if (r == 0) {       // 空网格
            return path;
        }
        c = obstacleGrid[0].length;
        //起点和终点有障碍，返回空路径
        if (obstacleGrid[r - 1][c - 1] == 1||obstacleGrid[0][0] == 1) {
            return path;
        }
        boolean[][] visit = new boolean[r][c];  // 记录数组
        backtrack(obstacleGrid, 0, 0, visit);
        return path;
    }

    public boolean backtrack(int[][] obstacleGrid, int x, int y, boolean[][] visit) {
        // 越界，有障碍，已访问
        if (x >= r || y >= c || obstacleGrid[x][y] == 1 || visit[x][y]) {
            return false;
        }
        // 如果不是以上情况，说明这个格子值得探索，做出选择
        path.add(Arrays.asList(x, y));
        visit[x][y] = true;
        // 选择后是否到达终点
        if (x == r - 1 && y == c - 1) {
            return true;
        }
        // 选择后没到终点，先尝试向下，再尝试向右，神奇的或运算，这里保证了，
        // 只要一条路走通了，直接返回，避免了solution算法中多条路的问题。巧妙的设计。
        if (backtrack(obstacleGrid, x + 1, y, visit) || backtrack(obstacleGrid, x, y + 1, visit)) {
            return true;
        }
        // 既不能向下也不能向右，是个死胡同，撤销选择，这里把visit[x][y] = false;会超时，本题这个地方可能用例有不足。
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args){
        /*List list = new ArrayList(3);
        System.out.println(list.size());
        list.add(1);
        System.out.println(list.size());*/
        Solution solution = new Solution();
        int[][] a = {{0,0,0},{0,1,0},{0,0,0}};
        solution.pathWithObstacles(a);
    }

}
