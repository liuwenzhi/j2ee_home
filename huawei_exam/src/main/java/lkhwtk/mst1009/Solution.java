package lkhwtk.mst1009;

/**
 * 面试题 10.09. 排序矩阵查找
 * 注意输入可能有空数组
 * 个人思路
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //单独处理空数组的情况
        if(matrix.length==0){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j] == target){
                    return true;
                }else if(matrix[i][j] > target){
                    //每行元素呈现递增关系，大了就换下一行
                    break;
                }
            }
        }
        return false;
    }
}
