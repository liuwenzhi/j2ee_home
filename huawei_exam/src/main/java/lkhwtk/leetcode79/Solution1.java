package lkhwtk.leetcode79;

/**
 * 核心思路：回溯
 * 参考题解：回溯算法（Java）
 * 这个题解比官方题解效率略高
 */
public class Solution1 {
    /**方向数组变量*/
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    /**入参二维数组行数*/
    private int rows;
    /**入参二维数组列数*/
    private int cols;
    /**入参检索字符串长度*/
    private int len;
    /**标记元素是否访问过的二维数组*/
    private boolean[][] visited;
    /**入参检索单词转字符数组*/
    private char[] charArray;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        if (rows == 0) {
            return false;
        }
        cols = board[0].length;
        visited = new boolean[rows][cols];

        this.len = word.length();
        this.charArray = word.toCharArray();
        this.board = board;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int begin) {
        //递归结束条件，这里直接开始比较了，begin达到了len-1，就判断一下board中最后一个元素是否等于入参字符数组的最后一个元素
        if (begin == len - 1) {
            return board[x][y] == charArray[begin];
        }
        if (board[x][y] == charArray[begin]) {
            visited[x][y] = true;
            //注意这种二维数组遍历方式，很酷
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (dfs(newX, newY, begin + 1)) {
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    /**
     * 判断坐标是否在二维数组范围内
     */
    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

}
