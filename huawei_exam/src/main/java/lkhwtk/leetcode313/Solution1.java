package lkhwtk.leetcode313;

/**
 * 参考思路：313. 超级丑数-堆，这个思路实际和Solution1一致，
 * 图文更清晰一些，一些概念背一下。
 */
public class Solution1 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int [] dp=new int[n];
        dp[0]=1;
        int k=primes.length;
        int []index=new int[k];
        for(int i=1;i<n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<k;j++){
                if(min>dp[index[j]]*primes[j]){
                    min=dp[index[j]]*primes[j];
                }
            }
            dp[i]=min;
            //滑动index
            for(int j=0;j<k;j++){
                if(min==dp[index[j]]*primes[j]){
                    index[j]++;
                }
            }
        }
        return dp[n-1];
    }
}
