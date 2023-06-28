package lkhwtk.leetcode1011;

import java.util.Arrays;

/**
 * Solution的另一种写法，二分查找while、循环条件和右指针移动方式的变化。
 * 最后左右指针要么指向同一个位置，要么右指针在左指针左边，肯定返回左指针
 */
public class Solution1 {
    public int shipWithinDays(int[] weights, int days) {
        // 确定二分查找左右边界
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left <= right) {
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= days) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }
}
