package lkhwtk.leetcode268;

/**
 * 位运算
 * 参考题解：官方
 * 注意抑或运算的性质，抑或运算满足交换律和结合律。本题其实和136题很像，就是在136题基础上增加一层包装
 * offer53_II思路同本题
 */
public class Solution1 {
    public int missingNumber(int[] nums) {
        //初始化missing为nums.length，数组中能够表示出nums.length这个值，但是表示不出nums.length这一位，
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

}
