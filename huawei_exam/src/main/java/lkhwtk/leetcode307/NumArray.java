package lkhwtk.leetcode307;

/**
 * 307. 区域和检索 - 数组可修改
 * 本题按照最原始的思路，直接计算会超时，用例能通过86%
 */
public class NumArray {

    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public void update(int index, int val) {
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i = left;i<=right;i++){
            sum += nums[i];
        }
        return sum;
    }
}
