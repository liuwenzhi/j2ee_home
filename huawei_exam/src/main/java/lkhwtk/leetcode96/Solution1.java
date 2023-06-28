package lkhwtk.leetcode96;

/**
 * 96. 不同的二叉搜索树
 * 参考题解：画解算法：96. 不同的二叉搜索树
 * 参考题解来理解
 */
public class Solution1 {
    public int numTrees(int n) {
        //dp[i]代表长度为i的序列，可能构成的不同二叉搜索树的个数
        int[] dp = new int[n+1];
        //0个节点给个值1，便于后边算法乘法计算
        dp[0] = 1;
        //1个节点只有一种情况，值是1
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++)
            for(int j = 1; j < i + 1; j++)
                dp[i] += dp[j-1] * dp[i-j];

        return dp[n];
    }

}
