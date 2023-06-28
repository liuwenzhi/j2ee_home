package lkhwtk.mst0107;

/**
 * 面试题 01.07. 旋转矩阵
 * 注意：本题和54,59题有很大不同，参考这个题解：简单Java 原地双百～
 * 按照主对角线对调一次，然后每一行按照中间元素对调一次，极给力的思路
 * 和主站48题思路一致
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        //按照主对角线发转一次，注意两个for循环的初始化和条件设置，需要避免转过去了又转回来的情况
        //画几遍矩阵就会发现，按照主对角线对调元素，不能遍历最后一行，每次j从i+1开始遍历
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //获取元素中间点，右移动一位相当于除以2
        int mid = len >> 1;
        for(int i=0;i<len;i++){
            for(int j=0;j<mid;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len-j-1];
                matrix[i][len-j-1] = temp;
            }
        }
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        solution.rotate(matrix);
        //右移一位相当于除以2
        System.out.println(2>>1);
        System.out.println(4>>1);
        System.out.println(5>>2);
        System.out.println(6>>2);


    }
}
