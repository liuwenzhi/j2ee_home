package lkhwtk.leetcode26;

/**
 * 26. 删除有序数组中的重复项
 * 核心思路，把不重复的元素移动到数组左边，原有数组为有序数组，移动之后依然有序
 * 本题实际采用了占位的思路，即存在重复值得情况下，在左指针后边流出空位，然后加入后边不重复的元素
 * 本题也是一个很基础而且很巧的算法，可以作为大题的具体某个步骤
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        //如果数组长度为1或者0，则直接返回数组长度，无重复项
        if(nums.length <= 1){
            return nums.length;
        }
        //定义一前一后两个指针 1 1 2
        int index = 0;
        int after = 1;
        while(after<nums.length){
            //如果前后指针的值相等，则后指针移动
            if(nums[index]==nums[after]){
                after++;
            }else{
                //如果前后指针的值不等，则将index指针下一位的值设置为after位置的值
                nums[++index] = nums[after];
                after++;
            }
        }
        //index是从0开始记录，最后总量需要+1
        return index+1;
    }
}
