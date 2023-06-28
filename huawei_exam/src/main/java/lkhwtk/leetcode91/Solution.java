package lkhwtk.leetcode91;

/**
 * 91. 解码方法
 * 核心思路：动态规划
 * 参考题解：C++ 我认为很简单直观的解法
 * 本题纯粹根据入参总结规律，建立动态规划模型，建立状态转移方程
 */
public class Solution {
    public int numDecodings(String s) {
        //如果s以0开始，或者直接就是0，则返回0
        if("0".equals(s)||s.startsWith("0")){
            return 0;
        }
        //dp[i]代表截止到i为止，译码方案数
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        int index = 2;
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='0'){
                //数字为0的情况，如果前一个字符不是1或者2，就是无法编译
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                    //如果0的前一位是1或者2，那么一起编码，不增加编码情况
                    dp[index] = dp[index-2];
                }else{
                    return 0;
                }
            }else if(s.charAt(i-1)=='1'){
                //s.charAt(i-1)和c分开编码为dp[index-1]，合并译码为dp[index-2]
                dp[index] = dp[index-1]+dp[index-2];
            }else if(s.charAt(i-1)=='2'&&(c>='1'&&c<='6')){
                //s.charAt(i-1)和c分开编码为dp[index-1]，合并译码为dp[index-2]
                dp[index] = dp[index-1]+dp[index-2];
            }else{
                //不包含以上几种情况，就不会产生新的编码方式
                dp[index] = dp[index-1];
            }
            index++;
        }
        return dp[s.length()];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("226"));
    }
}
