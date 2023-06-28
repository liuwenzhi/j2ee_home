package lkhwtk.leetcode189;

/**
 * 核心思路：数组翻转
 * 参考题解：【数组翻转】旋转数组，参考这个题解的动态图看下效果，非常明显
 *          配合官方题解看下
 */
public class Solution1 {
    public void rotate(int[] nums, int k) {
        //k先取余，避免不必要的计算
        k %= nums.length;
        //先翻转整个数组
        reverse(nums, 0, nums.length - 1);
        //分别翻转前k个元素和后边length-k个元素
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 公共方法：指定数组从start开始到end进行翻转的方法
     */
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
