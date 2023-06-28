package lkhwtk.leetcode461;

/**
 * Brian Kernighan 算法
 * 这个参考下，掌握前两种思路就ok
 */
public class Solution2 {
    public int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            s &= s - 1;
            ret++;
        }
        return ret;
    }
}
