package lkhwtk.leetcode280;

import java.util.Arrays;

/**
 * 280. 摆动排序
 * 参考题解：官方
 */
public class Solution {
    /**
     * 思路1：现将数组排序，然后从第二个元素开始，逐对儿元素交换位置，顺序是：0不动，1和2交换，3和4交换...
     * 注意for循环中的条件是 i < nums.length - 1; i += 2
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
