package lkhwtk.leetcode16;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 参考15题思路，先对数组进行排序，排序之后，固定一个位置，通过二分查找的方式找另外两个位置，
 * 在使用二分查找的过程中，判断总和与目标值的差值，大了还是小了，来移动指针，找到最接近的值
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int result = nums[0]+nums[1]+nums[2];
        if(len == 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int L = i+1;
            int R = len-1;
            while(L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                //找绝对值和最小
                if(Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
                if(sum > target){
                    //三数之和比target大，右指针--，先做去重，去完重之后再做一次累加，做了去重，实际效率也没有大的提升
                    while (L < R && nums[R-1] == nums[R]) --R;
                    R--;
                }else if(sum < target){
                    //三数之和比target小，左指针++，先做去重，去完重之后再做一次累加，实际效率也没有大的提升
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    L++;
                }else{
                    //三数之和等于target，直接返回这个值
                    return sum;
                }
            }
        }
        return result;
    }
}
