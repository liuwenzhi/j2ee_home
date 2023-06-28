package lkhwtk.leetcode283;

/**
 * 参考题解：动画演示 283.移动零 精选
 * 核心思路：把非0元素移动到前边去，后边用0补位
 */
public class Solution1 {
    public void moveZeroes(int[] nums) {
        if(nums==null){
            return;
        }
        int index=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[index] = nums[i];
                index++;
            }
        }
        //这个方案没有使用元素替换方式，最后需要补下0
        for(int i=index;i<n;i++){
            nums[i] =0;
        }
    }

    /**
     * 替换数组中两个元素的位置
     */
    /*private void swap(int left,int right,int[] nums){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }*/
}
