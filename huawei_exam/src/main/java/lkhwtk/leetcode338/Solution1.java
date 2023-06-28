package lkhwtk.leetcode338;

/**
 * 直接统计方式，效率也偏低
 */
public class Solution1 {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i=0;i<=n;i++){
            result[i] = countNum(i);
        }
        return result;
    }

    private int countNum(int num){
        char[] c = Integer.toBinaryString(num).toCharArray();
        int ans = 0;
        for(int i=0;i<c.length;i++){
            if("1".equals(c[i]+"")){
                ans++;
            }
        }
        return ans;
    }
}
