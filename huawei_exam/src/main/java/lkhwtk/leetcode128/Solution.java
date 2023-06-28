package lkhwtk.leetcode128;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 参考题解：最长连续序列 官方
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        //原始数组去重
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        //最长连续序列
        int longestStreak = 0;
        //从去重set集合中遍历元素
        for (int num : num_set) {
            //如果set集合中包含了当前元素值的前一个数值，比如4包括3,3包括2，则继续遍历下一个数字，
            //这里只从一个序列中最前边的数字开始往后找，要找到包含当前数字+1的，这个if判断过滤掉了一多部分不必要的比较
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                //如果包含当前元素值+1，则当前元素值自增，子序列长度增加，继续循环找下一个元素
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                //最后比较从这个num开始的子序列长度和最大子序列长度
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
