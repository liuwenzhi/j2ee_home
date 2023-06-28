package lkhwtk.leetcode338;

/**
 * 参考题解：清晰的思路 精选
 * 该思路非常好，可以总结为一维动态规划
 */
public class Solution2 {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        //1到n这几个元素中，只可能是奇数或者偶数，如果是偶数，1的个数和该数字/2那个数字一致，因为
        //二进制偶数末位是0，除以2相当于右移一位，去掉了一个0,1的个数不受影响，如果是奇数，那么它比之前的偶数多一个1
        for(int i=1;i<=n;i++){
            if(i%2==0){
                dp[i] = dp[i/2];
            }else{
                dp[i] = dp[i-1]+1;
            }
        }
        return dp;
    }
}
