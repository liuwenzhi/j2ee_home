package lkhwtk.leetcode283;

/**
 * 参考题解：官方
 *
 * 思路：双指针
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null){
            return;
        }
        int left =0,right = 0;
        int n = nums.length;
        //算法中存在自己和自己替换的情况，交换方法中增加了如果左右值相等，就不换的情况
        while(right<n){
            //left停顿的位置，是数组中的0值，
            if(nums[right]!=0){
                //如果左右指针位于同一个位置，则替换算法中不会动
                swap(left,right,nums);
                left++;
            }
            right++;
        }
    }

    /**
     * 替换数组中两个元素的位置
     */
    private void swap(int left,int right,int[] nums){
        if(left==right){
            return;
        }
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args){
        int a[] = {1,2,3,0,5,6,7,0};
        Solution solution = new Solution();
        solution.moveZeroes(a);
    }
}
