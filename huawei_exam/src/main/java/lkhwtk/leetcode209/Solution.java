package lkhwtk.leetcode209;

/**
 * 209. 长度最小的子数组
 * 参考题解：官方滑动窗口，注意本题中数组中元素均为正整数
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int length = nums.length;
        //先定义一个超过数组长度的结果
        int result = length+1;
        int sum = 0;
        while(right<length){
            sum += nums[right];
            while(sum>=target){
                result = Math.min(result,right-left+1);
                //因为数组里边都是正数，直接left往右移动，此时不用考虑right往左移动，因为left右移动前left和right之间的数字
                //刚刚好满足大于等于target的情况，此时right左移肯定不满足条件，而left右移有可能满足条件，left右移之后，也不
                //用考虑right左移的情况
                sum-=nums[left];
                left ++;
            }
            right++;
        }
        return result ==(length+1)?0:result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int a[] = {2,3,1,2,4,3};
        solution.minSubArrayLen(7,a);
    }
}
