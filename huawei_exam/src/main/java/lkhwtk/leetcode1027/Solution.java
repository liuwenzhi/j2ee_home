package lkhwtk.leetcode1027;

import java.util.HashMap;
import java.util.Map;

/**
 * 1027. 最长等差数列
 * 参考题解：动态规划、哈希表优化
 */
public class Solution {
    public int longestArithSeqLength(int[] A) {
        int len = A.length;
        //定义一个二维dp数组，dp[i][j]代表以A[i],A[j]两个数字结尾的等差数列，数列中A[i]在A[j]前边，只初始化dp二维数组的右上边部分即可
        //因为等差数列最少元素数量是2，在i<j的时候初始化值为2
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(i<j){
                    dp[i][j] = 2;
                }
            }
        }

        //用一个map集合保存每一个元素A[i]和A[i]对应的下标
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                //前一个元素实际是A[i]-(A[j]-A[i])，括号打开之后是2 * A[i] - A[j]
                int target = 2 * A[i] - A[j];
                if(map.containsKey(target)) {
                    //dp[i][j] = 以target位置和i位置两个元素为结尾的子序列值+1
                    dp[i][j] = dp[map.get(target)][i] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
            map.put(A[i], i);
        }
        return max;
    }
}
