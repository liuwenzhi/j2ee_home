package lkhwtk.leetcode79;

/**
 * 79. 单词搜索
 * 核心思路：图的深度优先遍历
 * 思路参考：速看dfs,简单易懂
 * 这个题解效率最高，实现思路和695题相似，都是采用图的深度优先遍历，本题属于深度优先遍历配回溯算法
 */
public class Solution {
    /**result是最终返回结果*/
    boolean result = false;
    /**m是入参二维数组的行数*/
    int m;
    /**n是入参二维数组的列数*/
    int n;
    /**length是入参查找单词的长度*/
    int length;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        length = word.length();
        //used数组
        boolean[][] used = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //在图的深度优先遍历中找到了结果，返回true
                if(result) {
                    return result;
                }else if(board[i][j] == word.charAt(0)){
                    //找到入参二维矩阵首个包含word首字母的位置，从这个位置开始递归遍历
                    dfs(board, used, i, j, 0, word);
                }
            }
        }
        return result;
    }
    public void dfs(char[][] board, boolean[][] used, int x, int y, int temp, String word){
        if(temp == length) {
            //递归结束条件，temp的长度达到了搜索字符的长度，返回result
            result = true;
            return;
        }
        if(x >= 0 && x < m && y >= 0 && y < n){
            if(!used[x][y] && board[x][y] == word.charAt(temp)){
                used[x][y] = true;
                dfs(board, used, x - 1, y, temp + 1, word);
                dfs(board, used, x + 1, y, temp + 1, word);
                dfs(board, used, x, y - 1, temp + 1, word);
                dfs(board, used, x, y + 1, temp + 1, word);
                //遍历完之后，再将该位置是否用过设置为false，实际起到了一个类似回溯的效果，可能一条路径没走通，然后重新走一遍
                used[x][y] = false;
            }
        }else{
            //这里可以不加，加上使递归的逻辑更加清晰
            return;
        }
    }
}
