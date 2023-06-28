package lkhwtk.leetcode416;

/**
 * 个人对Solution二维动态数组的优化，降低为一维
 */
public class Solution1 {
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
        //创建一维动态规划数组，列：容量（包括 0），默认值全部为false
        boolean[] dp = new boolean[target + 1];

        dp[0]= true;

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = target; j >= 0; j--) {
                if (nums[i] == j) {
                    dp[j] = true;
                    continue;
                }
                //算上nums[i]在看看，此时一定要保证j - nums[i]>=0
                if (nums[i] < j) {
                    dp[j] |=  dp[j - nums[i]];
                }
                //由于状态转移方程的特殊性，提前结束，可以认为是剪枝操作，或操作，最后一列只要有一个是true就行，加上下边这行代码效率提升一倍
                if (dp[target]) {
                    return true;
                }
            }
        }
        return dp[target];
    }
}
