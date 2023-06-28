package lkhwtk.leetcode1162;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1162. 地图分析
 * 参考题解：🌊简单Java, 秒懂图的BFS～
 * 备注：曼哈顿距离：横坐标差值绝对值+纵坐标差值绝对值
 * 提示：
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 * 本题核心点是广度优先遍历
 */
public class Solution {
    public int maxDistance(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        // 先把所有的陆地都入队。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            //point数组拿的实际是坐标信息
            point = queue.poll();
            //如果是最后一批访问的位置，周围已经没有grid[newX][newY] != 0的情况了。
            int x = point[0], y = point[1];
            // 取出队列的元素，将其四周的海洋入队。
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                    continue;
                }
                //这里我直接修改了原数组，因此就不需要额外的数组来标志是否访问，注意这里的设计：
                //新位置的值等于旧位置的值+1，充分利用了陆地值是1的特点，从旧位置陆地到这里，需要经过的距离就是grid[newX][newY]-1
                grid[newX][newY] = grid[x][y] + 1;
                hasOcean = true;
                queue.offer(new int[] {newX, newY});
            }
        }

        // 没有陆地或者没有海洋，返回-1。
        if (point == null || !hasOcean) {
            return -1;
        }

        // 返回最后一次遍历到的海洋的距离，注意一定有一个减一，可以结合题解说明来理解
        return grid[point[0]][point[1]] - 1;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
        solution.maxDistance(grid);

    }
}
