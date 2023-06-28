package lkhwtk.leetcode96;

/**
 * 96. 不同的二叉搜索树
 * 参考题解：画解算法：96. 不同的二叉搜索树
 * 参考题解来理解
 */
public class Solution {
    public int numTrees(int n) {
        //dp[i]代表长度为i的序列，可能构成的不同二叉搜索树的个数，状态转移公式是卡特兰数公式，可参考核心题解的推理
        int dp[] = new int[n+1];
        //空节点算一个，主要是方便后边计算
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            //j只起到配合取dp中数据的作用，对具体dp赋值没有关系，直接想1,2,3个节点，3位头的三种情况dp[2]*dp[0],dp[1]*dp[1],dp[0]*dp[2]
            for(int j=1;j<=i;j++){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
