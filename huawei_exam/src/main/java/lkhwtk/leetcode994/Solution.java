package lkhwtk.leetcode994;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 * 参考题解：理清思路：为什么用 BFS，以及如何写 BFS 代码（Java/Python）
 * 核心思路一幕了然，图的广度优先遍历
 */
public class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        //注意：对图进行广度优先遍历，入参是二维数组，队列中存储行列坐标二元组，可以使用一个一维数组存储两个元素，一个行元素，一个列元素
        Queue<int[]> queue = new LinkedList<>();
        //新鲜橘子数量
        int freshNum = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    freshNum++;
                }else if(grid[i][j]==2){
                    //注意这种一维数组初始化方式，把腐烂的橘子添加到队列中
                    queue.add(new int[]{i,j});
                }
            }
        }
        int minutes = 0;
        //注意核心算法的循环条件：必须同时满足队列不为空，并且新鲜水果数量>0，可能队列不空，但是已经没有新鲜橘子了
        while(!queue.isEmpty()&&freshNum>0){
            //每进行一次广度优先遍历，minutes做一次自增
            minutes++;
            //做一个简单的优化：进行广度优先遍历前，统计一下队列中元素数量，每轮执行广度优先遍历的时候，只遍历n个记录，这样保证层和层之间各自统计自己层的，互不影响
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                //orange数组中存放的实际是腐烂橘子的横纵坐标
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
                //上方没超过边界，并且是新鲜橘子，腐烂掉
                if (r-1 >= 0 && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    freshNum--;
                    //将新腐烂掉的橘子放到队列里边下一轮遍历
                    queue.add(new int[]{r-1, c});
                }
                //下方没有超过边界，并且是新鲜橘子，腐烂掉
                if (r+1 < rows && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    freshNum--;
                    //将新腐烂掉的橘子放到队列里边下一轮遍历
                    queue.add(new int[]{r+1, c});
                }
                //左侧没有超过边界，并且是新鲜橘子，腐烂掉
                if (c-1 >= 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    freshNum--;
                    //将新腐烂掉的橘子放到队列里边下一轮遍历
                    queue.add(new int[]{r, c-1});
                }
                //右侧没有超过边界，并且是新鲜橘子，腐烂掉
                if (c+1 < cols && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    freshNum--;
                    //将新腐烂掉的橘子放到队列里边下一轮遍历
                    queue.add(new int[]{r, c+1});
                }
            }
        }

        if(freshNum>0){
            return -1;
        }else{
            return minutes;
        }
    }
}
