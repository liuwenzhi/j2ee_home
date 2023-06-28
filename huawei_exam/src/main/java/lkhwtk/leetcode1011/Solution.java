package lkhwtk.leetcode1011;

import java.util.Arrays;

/**
 * 1011. 在 D 天内送达包裹的能力
 * 参考题解：官方
 * 注意下本题通过Arrays.stream的方式对数组的处理，华为机试中可能会用到这种方式处理输入，39题就是一个典型的问题
 */
public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // 确定二分查找左右边界，左侧边界是单个货物最大重量，右侧边界是总重量
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = left+(right-left) / 2;
            // need 为需要运送的天数，最小是1天
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                //如果累计重量加上下一个货物重量weight>mid载重量，则天数加1，当前总重量变量值置为0，重新开始。
                //由于need初始值为1，不是从0开始，这里不用单独考虑最后拉下的一次，need已经是从1开始了。
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= days) {
                //满足条件的情况下，让right变小，看看有没有更短天数的解决方案
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
