package lkhwtk.leetcode518;

/**
 * 518. 零钱兑换 II
 * 参考题解：官方
 * 官方题解是2021年6月初给出，比其他几个说明更好，更便于理解。本题属于动态规划完全背包
 * 本题和面试题08.11基本一致
 * 2021年10月29日，华为二面是这个题，没搞定
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        //注意：一定是外层for循环遍历硬币，保证计算是一个组合的结果，不是进行排列
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                //注意本题和322题的区别，本题找到的是组合数，这里不用单独+1，直接把当前coin算法组合中元素就行了,322题找的是兑换次数，需要加上当前coin的兑换次数1
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] a = {1, 2,3,4,5,6,7,8,9,10};
        System.out.println(solution.change(10,a));
    }
}
