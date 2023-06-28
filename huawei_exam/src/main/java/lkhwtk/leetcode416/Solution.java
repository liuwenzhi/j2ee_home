package lkhwtk.leetcode416;

/**
 * 416. 分割等和子集
 * 参考题解：动态规划（转换为 0-1 背包问题）
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        // 题目已经说非空数组，可以不做非空判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        // 创建二维状态数组，行：物品索引，列：容量（包括 0），默认值全部为false
        boolean[][] dp = new boolean[len][target + 1];

        dp[0][0] = true;

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正，至少是这个答案，测试没有算上nums[i]
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                //算上nums[i]在看看，此时一定要保证j - nums[i]>=0
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }

                //由于状态转移方程的特殊性，提前结束，可以认为是剪枝操作，或操作，最后一列只要有一个是true就行，加上下边这行代码效率提升一倍
                if (dp[i][target]) {
                    return true;
                }
            }
        }
        return dp[len - 1][target];
    }

}
