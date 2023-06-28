package lkhwtk.leetcode303;

/**
 * 303. 区域和检索 - 数组不可变
 * 个人思路，效率偏低
 */
public class NumArray {

    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i=left;i<=right;i++){
            sum+=nums[i];
        }
        return sum;
    }
}
