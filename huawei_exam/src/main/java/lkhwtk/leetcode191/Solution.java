package lkhwtk.leetcode191;

/**
 * 191. 位1的个数
 * 参考华为机试15题解法，这种方式效率比较低
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        char[] c = Integer.toBinaryString(n).toCharArray();
        int num = 0;
        for(int i=0;i<c.length;i++){
            if("1".equals(c[i]+"")){
                num++;
            }
        }
        return num;
    }
}
