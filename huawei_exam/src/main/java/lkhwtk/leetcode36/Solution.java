package lkhwtk.leetcode36;

/**
 * 36. 有效的数独
 * 参考思路：36. 简单想法，最优思路：就按照从左往右、从上往下的顺序遍历一次board，完成3个条件的检验
 * 备注：本题只需要验证，不需要求解
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //这里不要乱：row数组的行数对应board数组的行数9，row数组的列数是0到9，一共10列，row中第一列不用管（数独没有0），
        //元素(i,j)j这个元素，在当前位置(i,j)是否出现过，1代表出现过，即j这个元素在原数组中第i行是否出现过
        int [][]row  =new int[9][10];
        //这里不要乱：col数组的行数对应borad数组的列数9，col数组的列数是0到9，一共10列，col中第一列不用管（数独没有0），
        //元素(i,j)j这个元素，在当前位置(i,j)是否出现过，1代表出现过，即j这个元素在原数组中第i列是否出现过
        int [][]col  =new int[9][10];
        //基于row和col的解释，box中（i,j）代表j这个元素，在原数组的第i个box中是否出现过，box说明信息参考题解
        int [][]box  =new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]=='.'){
                    continue;
                }
                //得到当前便利的数字
                int curNum = board[i][j]-'0';
                //curNum如果在当前行出现过
                if (row[i][curNum]==1){
                    return false;
                }
                //curNum如果在当前列出现过
                if (col[j][curNum]==1){
                    return false;
                }
                //curNum如果在当前box出现过
                if (box[j/3 + (i/3) * 3][curNum]==1){
                    return false;
                }
                //如果curNum在当前行，列和box中都没有出现，则将自定义数组中的值都置为1
                row[i][curNum]=1;
                col[j][curNum]=1;
                box[j/3 + (i/3) * 3][curNum]=1;
            }
        }
        return true;
    }
}
