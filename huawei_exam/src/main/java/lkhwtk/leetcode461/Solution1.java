package lkhwtk.leetcode461;

/**
 * 461. 汉明距离
 * 参考题解：官方
 */
public class Solution1 {

    /**
     * 采用抑或运算+位移的方式
     */
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int result = 0;
        while(n!=0){
            result += (n&1);
            n = n >> 1;//n >>= 1
        }
        return result;
    }
}
