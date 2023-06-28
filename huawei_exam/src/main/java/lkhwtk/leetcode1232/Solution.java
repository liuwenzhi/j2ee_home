package lkhwtk.leetcode1232;

/**
 * 1232. 缀点成线
 * 思路：百分百，秒杀，清晰易懂
 * 直接通过斜率比例判断，二轮复习本题简要过一下
 */
public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;
        //用乘法代替除法来做，判断相邻的三个点中，每两个点之间斜率相等即可，注意for循环中不包括0和len位置
        for (int i = 1; i < len - 1; ++i) {
            int y1 = coordinates[i][1] -coordinates[i-1][1];
            int x1 = coordinates[i][0] -coordinates[i-1][0];
            int y2 = coordinates[i+1][1] -coordinates[i][1];
            int x2 = coordinates[i+1][0] -coordinates[i][0];
            if (y1*x2 != y2*x1) {
                return false;
            }
        }
        return true;
    }
}
