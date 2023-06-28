package lkhwtk.leetcode27;

/**
 * 27. 移除元素
 * 个人想法：快慢指针
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while(fast<nums.length){
            //不断把快指针找到的不等于val的数据替换到慢指针位置，快指针一直往后走，慢指针是替换一次往后走一次
            if(nums[fast]!=val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
