package lkhwtk.offer21;

/**
 * 思路：快慢双指针，这个思路可参考下，有一个问题点：快慢指针都指向了同一个元素，也会替换一次。
 */
public class Solution1 {
    public int[] exchange(int[] nums) {
        int slow = 0, fast = 0;
        while(fast<nums.length){
            if(nums[fast]%2==1){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
}
