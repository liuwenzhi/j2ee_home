package lkhwtk.leetcode494;

/**
 * 494. 目标和
 * 参考题解：494. 目标和，动态规划之01背包问题，注意题解中这句话：可以求出 x = (S + sum) / 2 = target
 * 也就是我们要从nums数组里选出几个数，令其和为target，这里的target不是题目的入参target目标和，而是动态规划0,1背包的一个术语
 * 本题解基于一维数组实现0,1背包
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(S > sum || (S + sum) % 2 == 1) return 0;
        int target = (S + sum) / 2;
        //dp[i]代表填满容量为i的背包，一共有的方法数量
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //注意：一定是最外层遍历num，这里是一个组合，不是排列
        for(int num : nums){
            //使用一维数组实现01背包，每次从后往前遍历
            for(int j = target; j >= num; j--){
                //加入num之后，之前j-num+num就得到j了，所以个数相加，这里相对于普通01背包稍微有点不同，这里不涉及到比较大小，
                //而是在原有规划的结果下，在算上num这个值之后，增加的规划数量统计上。dp[j]是从上一轮规划中不算num时满足条件的数量，算上num就是累加dp[j-num]的值
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[target];
    }


}
