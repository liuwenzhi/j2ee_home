package lkhwtk.leetcode977;

/**
 * 参考题解：有序数组的平方（双指针：在nums中每次找两端绝对值小大的元素☀）
 */
public class Solution1 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        //双指针思路，一个头，一个尾
        int left = 0, right = n - 1;
        //index是存入res数组的下标位置，从后往前存，即从大往小存
        int index = n - 1;
        //双指针思路条件：左边不能越过右边
        while (left <= right) {
            //左边大，取左边，left++
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[index] = nums[left] * nums[left];
                left++;
            } else {
                //右边大，取右边，right--
                res[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
        return res;
    }

}
