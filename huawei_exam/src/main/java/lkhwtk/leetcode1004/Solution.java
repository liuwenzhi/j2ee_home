package lkhwtk.leetcode1004;

/**
 * 1004. 最大连续1的个数 III
 * 参考424题题解完成本题，注意：本题求解1的最大连续长度
 * 参考424题图解，整个过程中，窗口从左向右移动，处于不断滑动和扩张的过程
 */
public class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        //窗口中连续1的数量
        int one = 0;
        //历史窗口最大值，窗口中历史最大的1的个数
        int historyCharMax = 0;
        for ( ;right < nums.length; right++) {
            if(nums[right]==1){
                //one记录当前窗口中1的数量，右指针主动移动，拿到1则one自增
                one++;
                historyCharMax = Math.max(historyCharMax, one);
            }
            //如果窗口的宽度大于历史1的最大值+k，则窗口滑动，left++
            if (right - left + 1 > historyCharMax + k) {
                if(nums[left]==1){
                    //左指针被动移动，属于滑动的时候移动左指针，窗口中1的数量需要判断是否跟着减
                    one--;
                }
                left++;
            }
        }
        return nums.length - left;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {0};
        solution.longestOnes(nums,1);
    }
}
