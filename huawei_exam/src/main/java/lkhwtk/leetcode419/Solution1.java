package lkhwtk.leetcode419;

/**
 * 参考题解：DFS 和 寻找战舰头 （1 ms，99.82%）
 * 寻找战舰头的思路很有意思，要么X在上边界或者左边界，
 * 要么上方和左边都是. 这样就能找到一个战舰头
 */
public class Solution1 {

    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 判断是否是战舰头，要防止越界
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                    count++;
                }
            }
        }
        return count;
    }
}
