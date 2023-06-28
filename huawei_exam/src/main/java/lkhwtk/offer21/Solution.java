package lkhwtk.offer21;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 核心思路：首位双指针
 */
public class Solution {
    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            if(nums[i]%2==0&&nums[j]%2==1){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }else{
                if(nums[i]%2==1){
                    i++;
                }
                if(nums[j]%2==0){
                    j--;
                }
            }
        }
        return nums;
    }
}
