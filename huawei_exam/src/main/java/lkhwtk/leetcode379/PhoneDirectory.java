package lkhwtk.leetcode379;

import java.util.Arrays;

/**
 * 379. 电话目录管理系统
 * 本题对于初始化多个电话号码，1，2,...按照题目要求是10000个，
 * 直接初始化一个boolean数组，size设置为号码个数，初始值全都设置为true，用到的设置为false，释放了再设置为true
 * 这个思路非常方便
 */
public class PhoneDirectory {

    /**
     * 私有电话号码数组
     */
    private boolean[] nums;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        nums = new boolean[maxNumbers];
        Arrays.fill(nums,true);
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        for(int i=0;i<nums.length;i++){
            if(nums[i]){
                nums[i] = false;
                return i;
            }
        }
        return -1;

    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return nums[number];
    }

    /** Recycle or release a number. */
    public void release(int number) {
        nums[number] = true;
    }

}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */