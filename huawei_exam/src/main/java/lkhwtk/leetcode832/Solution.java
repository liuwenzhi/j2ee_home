package lkhwtk.leetcode832;

/**
 * 832. 翻转图像
 * 个人思路：直接干，耗时0秒
 */
public class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;
        //中间位置，直接用
        int mid = cols/2;
        for(int i=0;i<rows;i++){
            for(int j=0;j<mid;j++){
                int temp = image[i][j];
                image[i][j] = image[i][cols-1-j];
                image[i][cols-1-j] = temp;
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++) {
                if(image[i][j]==1){
                    image[i][j] = 0;
                }else{
                    image[i][j] = 1;
                }
            }
        }
        return image;
    }
}
