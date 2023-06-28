package lkhwtk.leetcode130;

/**
 * 130. 被围绕的区域
 * 思路参考：bfs+递归dfs+非递归dfs+并查集 精选
 * 被围绕的区域 官方
 * 基于图的深度优先搜索完成本题，注意本体中board里边存的是英文字母O不是数字0
 * 本题核心的解题点：能和边界上的O连通的O不动，连通不了的O
 * 本题思路同1020
 */
public class Solution {
    public void solve(char[][] board) {
        if(board==null||board.length==0){
            return;
        }
        //判断是否是边界
        boolean isEdge;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                isEdge = false;
                //如果是边界的情况，isEdge
                if(i==0 || j==0 || i==board.length-1 || j==board[i].length-1){
                    isEdge = true;
                }
                //根据题意：所有没有被包围的O都和边界上的O直接或者间接关联，通过边界上的0进行深度优先搜索，将直接或者间接关联的O都标记上*
                if(isEdge&&board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }
        //遍历经过深度优先搜索标记后的数组，将O填充为X，再把*变回O
        for(int i=0;i<board.length;i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }else if(board[i][j]=='*'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    /**
     * 从边界上的某一个O点开始深度优先搜索，将上下左右方向能和这个O点连接上的O都标记上*
     */
    private void dfs(char[][] board,int i,int j){
        //先过滤掉超范围的数据，或者标记为X的数据，或者已经被标记的O
        if(i<0||j<0||i>board.length-1||j>board[0].length-1||board[i][j]=='X'||board[i][j]=='*'){
            return ;
        }
        //标记星，这个思路类似于沉岛，标记为*的原始O点不会被改成X
        board[i][j] = '*';
        //深度优先遍历(i,j)的上下左右几个元素，是0都标记为*，一个思考点：这里按照上下左右的顺序递归遍历最省时间，换了顺序不影响功能，但是更耗时
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }

    public static void main(String[] args){
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        Solution solution = new Solution();
        solution.solve(board);
    }
}
