package lkhwtk.leetcode1262;

/**
 * 1262. 可被三整除的最大和
 * 参考题解：动态规划与状态转移
 * 核心思路：动态规划，一个数和3的余数无外乎0,1,2三种情况，定义dp[i][j]
 * 为到第i-1个数为止，余数分别为0,1,2的最大和，建立动态转移方程的方式参考题解说明，
 * 注意java版本有一些坑在，参考注释
 */
public class Solution {
    public int maxSumDivThree(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][3];
        //dp[0]赋初始值
        if(nums[0]%3==0){
            //第一个数能整除3的情况
            dp[0][0] = nums[0];
        }else if(nums[0]%3==1){
            //第一个数除以3余1的情况
            dp[0][1] = nums[0];
        }else{
            //第一个数除以3余2的情况
            dp[0][2] = nums[0];
        }
        //核心算法部分
        for(int i=1;i<n;i++){
            if(nums[i]%3==0){
                //余数为0，dp[i][0]直接累加计算
                dp[i][0] = dp[i-1][0]+nums[i];
                if(dp[i-1][1]!=0) {
                    //如果dp[i-1][1]不等于0，可以累加，保证累加之后余数还是1，这一步是坑点
                    dp[i][1] = dp[i - 1][1] + nums[i];
                }else{
                    //如果dp[i-1][1]等于0，那么直接把dp[i][1]赋值为dp[i-1][1]
                    dp[i][1] = dp[i - 1][1];
                }
                if(dp[i-1][2]!=0) {
                    //如果dp[i-1][2]不等于0，可以累加，保证累加之后余数还是2，这一步是坑点
                    dp[i][2] = dp[i - 1][2] + nums[i];
                }else{
                    //如果dp[i-1][2]等于0，那么直接把dp[i][2]赋值为dp[i-1][2]
                    dp[i][2] = dp[i - 1][2];
                }
            }else if(nums[i]%3==1){
                //余数为1，1之前的累加+1算到2,0之前的累加+1算到1,2之前的累加+1算到0
                if(dp[i-1][2]!=0) {
                    //如果dp[i-1][2]不等于0，可以累加，保证累加之后余数是0
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] + nums[i]);
                }else{
                    //如果dp[i-1][2]等于0，不能累加，此时还没有余数为2的累加和，dp[i][0] 赋值为 dp[i-1][0]
                    dp[i][0] = dp[i-1][0];
                }
                //dp[i-1][0]是0或者不是0不影响dp[i][1]的赋值，不用单独判断
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
                if(dp[i-1][1]!=0) {
                    //如果dp[i-1][1]不等于0，可以累加，保证累加之后余数是2
                    dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + nums[i]);
                }else{
                    //如果dp[i-1][1]等于0，不能累加，此时还没有余数为1的累加和，dp[i][2] 赋值为 dp[i-1][2]
                    dp[i][2] = dp[i-1][2];
                }
            }else{
                //余数为2，1之前的累加+2算到0,2之前的累加+2算到1,0之前的累加+2算到2
                //说明参考余数是1的情况
                if(dp[i-1][1]!=0) {
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);
                }else{
                    dp[i][0] = dp[i - 1][0];
                }
                if(dp[i-1][2]!=0) {
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] + nums[i]);
                }else{
                    dp[i][1] = dp[i-1][1];
                }
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + nums[i]);
            }
        }
        return dp[n-1][0];
    }

    public static void main(String[] args){
        System.out.println(18/3);
        System.out.println(18%3);
        int[] nums = {3,6,5,1,8};
        Solution solution = new Solution();
        System.out.println(solution.maxSumDivThree(nums));
    }
}
