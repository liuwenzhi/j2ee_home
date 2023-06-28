package lkhwtk.leetcode240;

/**
 * 240. 搜索二维矩阵 II
 * 参考面试题1009题思路
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        //初始化开始的位置,从右上角开始
        int currentRow = 0;
        int currentColumn = matrix[0].length - 1;
        //循环过程中，行往下，列从右往左来
        while(currentRow < matrix.length && currentColumn >= 0){
            //如果当前位置的值等于target，则返回true
            if(matrix[currentRow][currentColumn] == target){
                return true;
            }
            //如果当前位置的值小于target，此时左上方都比target小，则行指针下移，肯定不能往右移，因为从右边过来的，之前从右边过来那个位置的右边和下边都比target大，或者是边界
            if(matrix[currentRow][currentColumn] < target){
                currentRow++;
            }else{
                //如果当前位置的值大于target，此时右下方都比target大，则列指针左移，肯定不能往上移，从上边下来的，之前从上边过来的位置左边和上边都比target小，只能往左走
                currentColumn--;
            }
        }
        return false;

    }
}
