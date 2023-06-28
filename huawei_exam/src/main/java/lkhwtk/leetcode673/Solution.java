package lkhwtk.leetcode673;

import java.util.Arrays;

/**
 * 673. 最长递增子序列的个数
 * 参考题解：动态规划（动图辅助理解，如有帮助请点个赞），这个是一个C++题解，核心思路表达很清晰
 * 动态规划解最长子序列子串等一类问题之最长连续递增序列[Reindeer]
 * 备注：子串与子序列区别：子串不可跳跃，子序列可以跳跃，如 “AC”是“ABCDEFG”的子序列，而不是子串。 而“ABC”则是其子串（这一点整理到公共部分）
 * 本题难点在于子序列不连续。找最长递增子序列的方式和300题一致。
 */
public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        //动态规划，以当前位置元素为最后一个位置可组成的最长子序列长度
        int[] dp = new int [length];
        //以当前位置元素为最后一个位置可组成最长子序列的序列数
        int[] count = new int[length];
        //给数组dp赋初始值，每一个位置都可以以自己为递增子序列，最小长度为1
        Arrays.fill(dp,1);
        //给数组count赋初始值，每一个位置以自己为递增子序列的情况下，序列数为1
        Arrays.fill(count,1);
        for(int i=1;i<length;i++){
            for(int j=0;j<i;j++){
                //在nums[j]<nums[i]时符合递增情况
                if(nums[j]<nums[i]){
                    //针对于以i结尾的递增子串，第一次找长度为dp[j]+1并且以dp[i]结尾的序列
                    if(dp[j]+1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if(dp[j]+1 == dp[i]) {
                        //针对于以i结尾的递增子串，第二次或者之后更多次找到长度为dp[j]+1并且以dp[i]结尾的序列，比如题干中的1 3 5 7和1 3 4 7
                        count[i] += count[j];
                    }
                }
            }
        }
        //max获取最长子序列长度
        int max = 0;
        for(int i=0;i<length;i++){
            max = Math.max(max,dp[i]);
        }
        //找到最长子序列，统计其序列个数
        int result = 0;
        for(int i=0;i<length;i++){
            if(dp[i] == max){
                result += count[i];
            }
        }
        return result;
    }
}
