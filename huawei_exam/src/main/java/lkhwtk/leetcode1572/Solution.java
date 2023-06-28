package lkhwtk.leetcode1572;

/**
 * 1572. 矩阵对角线元素的和
 */
public class Solution {
    public int diagonalSum(int[][] mat) {
        int rows = mat.length;
        //只有一个元素的正方形矩阵
        if(rows==1){
            return mat[0][0];
        }
        int sum = 0;
        //主对角线和
        for(int i=0;i<rows;i++){
            sum += mat[i][i];
        }
        //副对角线和，在奇数行列的情况下，副对角线会和主对角线有重合的元素
        for(int i=0;i<rows;i++){
            int j = rows-i-1;
            if(i!=j){
                sum+=mat[i][j];
            }
        }
        return sum;
    }
}
