package lkhwtk.leetcode289;

/**
 * 289. 生命游戏
 * 参考题解：官方，注意：本题最大的坑点在于：多个细胞的存活和死亡同时发生，要基于原数组，
 * 创建另外一个数组，输入状态信息。不要考虑原数组中一个细胞的变换对另一个细胞的影响，那
 * 样就彻底乱套了。
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        //单独定义一个方向数组
        int[] neighbors = {0, 1, -1};
        int rows = board.length;
        int cols = board[0].length;
        // 创建复制数组 copyBoard
        int[][] copyBoard = new int[rows][cols];
        // 从原数组复制一份到 copyBoard 中
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                copyBoard[row][col] = board[row][col];
            }
        }
        // 遍历面板每一个格子里的细胞
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // 对于每一个细胞统计其八个相邻位置里的活细胞数量
                int liveNeighbors = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        //neighbors[i]、neighbors[j]可以有一个为0，不能同时等于0，因为遍历周围8个元素
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);
                            //r、c位置元素在矩阵边界范围内，并且是活细胞，则统计值+1
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (copyBoard[r][c] == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }
                //规则 1 或规则 3，活细胞周围8个细胞少于两个活细胞或者大于三个活细胞（规则二可以不用管）
                if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 0;
                }
                // 规则 4 死细胞周围正好有三个活细胞
                if (copyBoard[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 1;
                }
            }
        }
        System.out.println("");

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] a = {{1,0},{0,1}};
        solution.gameOfLife(a);
    }
}
