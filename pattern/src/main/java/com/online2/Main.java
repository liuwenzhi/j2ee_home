package com.online2;

/**
 * 华为二面代码,2021年10月30日整理
 * 动态规划，完全背包问题
 */
public class Main {
    public int change(int amount) {
        int[] dp = new int[amount + 1];
        //dp[0]=1方便后边计算，比如用5兑换5，有一种情况dp[5]+=dp[0]
        dp[0] = 1;
        //注意：一定是外层for循环遍历硬币，保证计算是一个组合的结果，不是进行排列
        for (int i=1;i<=amount;i++) {
            for (int j = i; j <= amount; j++) {
                //dp[]数组中，每个元素都涉及到重复累加
                dp[j] += dp[j - i];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args){
        Main main = new Main();
        System.out.println(main.change(20));
    }
}
