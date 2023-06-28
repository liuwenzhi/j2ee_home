package lkhwtk.leetcode540;

/**
 * 抑或运算思路：针对于一个数组，重复元素的抑或运算结果为0，
 * 对数组整体进行一次抑或运算之后，就会得到只出现一次的元素
 * 本题同136题，一个思路
 */
public class Solution1 {
    public int singleNonDuplicate(int[] nums) {
        //注意这个性质：0和任何数抑或得到结果都是数字本身
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
