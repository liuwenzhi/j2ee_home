package lkhwtk.leetcode414;

/**
 * 参考题解：414. 空间O(1) 时间O(n)两种方法和思路
 * 绕了吧唧一个思路，后边有需求看下，效率最高。
 * 备注：题解在第二页
 */
public class Solution3 {
    private long MIN = Long.MIN_VALUE;    // MIN代表没有在值

    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) throw new RuntimeException("nums is null or length of 0");
        int n = nums.length;

        int one = nums[0];
        long two = MIN;
        long three = MIN;

        for (int i = 1; i <  n; i++) {
            int now = nums[i];
            if (now == one || now == two || now == three) continue;    // 如果存在过就跳过不看
            if (now > one) {
                three = two;
                two = one;
                one = now;
            } else if (now > two) {
                three = two;
                two = now;
            } else if (now > three) {
                three = now;
            }
        }

        if (three == MIN) return one;  // 没有第三大的元素，就返回最大值
        return (int)three;
    }
}
