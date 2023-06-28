package lkhwtk.leetcode31;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 参考题解：下一个排列算法详解：思路+推导+步骤，看不懂算我输！
 * 工具性代码可参考官方
 * 注意：下一个排列的概念在这个题解中好好看下
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        //从后往前找，找到第一个前一个元素比后一个元素小的位置i
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //如果当前数组不是一个纯递减序列的话（i=-1,按照题意直接执行后边的reverse翻转方法），就涉及到元素位置交换
        if (i >= 0) {
            int j = nums.length - 1;
            //从后往前，找到第一个实际比nums[i]大的元素，然后交换i和j元素位置
            while (j > i+1 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
            //交换完i和j之后，将第i位后边的元素置为升序，注意Arrays.sort做指定位置排序，是前包含后不包含
            Arrays.sort(nums,i+1,nums.length);
        }else{
            //如果nums是一个纯递减数组，则从开始位开始反转，或者直接给排序也行
            reverse(nums,0);
            //Arrays.sort(nums);
        }

    }

    /**
     * 交换数组中两个元素的位置
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 从一个指定位置开始到结束翻转数组元素，采用首尾双指针方式进行翻转
     */
    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args){
        int[] a = {1,2,3,7,6,5,4};
        Arrays.sort(a,3,7);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

}
