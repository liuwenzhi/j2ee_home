package lkhwtk.offer14_I;

/**
 * 剑指 Offer 14- I. 剪绳子
 * 参考题解：剑指 Offer 14- I. 剪绳子，还是动态规划好理解，但是贪心真的快
 * 参考题解中的贪心思路，小于4返回n-1，大于4的尽量拆除和3相关的
 * 本题和主站343题一致。
 */
public class Solution {
    public int cuttingRope(int n) {
        if(n < 4){
            return n - 1;
        }
        int res = 1;
        while(n > 4){
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
