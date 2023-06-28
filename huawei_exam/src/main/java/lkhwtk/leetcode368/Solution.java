package lkhwtk.leetcode368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 * 参考题解：适合新手朋友的视频题解，这个题解可以看一部分作为入门
 * 核心动态规划思路：对数组进行排序，然后对于一个满足条件的子集例如：[1,2,4]
 * 里边有一个最大的元素，如果还存在一个数字比如8，对最大这个数字4取余==0，那么
 * 就把这个数字加入到这个数组中，子集变成[1,2,4,8]，这样就整理出了一个动态规划思路
 * 参考题解：【宫水三叶の相信科学系列】详解为何能转换为序列 DP 问题
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //先对数组进行排序
        Arrays.sort(nums);
        int n = nums.length;
        //dp[i]代表只考虑前i个数字，以第i个数为结尾的最长[整数子集]的长度
        int[] dp = new int[n];
        //g数组是一个辅助数组，用于记录每一个状态是由哪个状态转移过来的，就是当前找到的这个dp[i]对应的序列，当前元素的前一个元素是哪个
        //单独添加这个数组原因是通过动态规划算法，只能得到最大整除子集的长度，需要单独找到子集中全部元素，需要借助这个数组
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            // 至少包含自身一个数，因此起始长度为 1，由自身转移而来
            int len = 1, prev = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    // 动态规划最核心的步骤：判断下满足能整除的情况下，dp[j]+1是否大于之前的len长度，如果能接在更长的序列后面，则更新「最大长度」&「从何转移而来」
                    if (dp[j] + 1 > len) {
                        len = dp[j] + 1;
                        prev = j;
                    }
                }
            }
            // 记录「最终长度」&「从何转移而来」
            dp[i] = len;
            g[i] = prev;
        }

        // 遍历所有的 dp[i]，取得「最大长度」和「对应下标」
        int max = -1, idx = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                idx = i;
                max = dp[i];
            }
        }

        // 使用 g[] 数组回溯出具体方案，在每一个dp[i]计算完成后，都保留了实际的上一个节点
        List<Integer> ans = new ArrayList<>();
        while (ans.size() != max) {
            //正序输出，ans.add(0,nums[idx])，代码中是按照逆序输出
            ans.add(nums[idx]);
            idx = g[idx];
        }
        return ans;
    }
}
