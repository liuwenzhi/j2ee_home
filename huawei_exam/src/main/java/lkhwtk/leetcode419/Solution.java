package lkhwtk.leetcode419;

/**
 * 419. 甲板上的战舰
 * 注意：本题题目中存在坑点，给的例子，是两艘战舰，不是4艘。
 * 本算法是个人思路，借助了200题和695题的思路，实际改变了夹板上的数据
 */
public class Solution {
    public int countBattleships(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int result = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if('X'==board[i][j]){
                    dfs(board,i,j);
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 图的深度优先遍历，将当前点水平和垂直能遍历到的点，题中已经明确说明，不会出现无效的夹板，
     * 所以在图的深度优先遍历中，基于countBattleships方法中双层循环的顺序，从左上点开始往
     * 下，往右执行，只需要向下，向右遍历即可（题干中说战舰只能水平或者垂直放置，N*1或者1*N）
     */
    void dfs(char[][] grid, int r, int c) {
        //获取二维数组行数
        int nr = grid.length;
        //获取二维数组列数
        int nc = grid[0].length;
        //行列超过边界，或者是0就停止访问，一次深度优先遍历执行结束，岛屿数量+1
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '.') {
            return;
        }
        //访问到数组中一个战舰，就将该值标记为.，已经访问过
        grid[r][c] = '.';
        //向下找
        dfs(grid, r + 1, c);
        //向右找
        dfs(grid, r, c + 1);
    }
}
