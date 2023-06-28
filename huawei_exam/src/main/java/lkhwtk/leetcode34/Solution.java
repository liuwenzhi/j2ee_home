package lkhwtk.leetcode34;

/**
 *
 *  34. 在排序数组中查找元素的第一个和最后一个位置
 *  个人思路：直接就开始找，if中的条件语句别太复杂，直接耗时0ms，可以和Solution1的二分查找pk效率
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int begin = -1;
        int end = -1;
        for(int i=0;i<nums.length;i++){
            if(begin<0&&nums[i]==target){
                //注意nums中只有一个元素的情况，这里需要给end也赋值下
                begin = i;
                end = i;
            }else if(end>=0&&nums[i]>target){
                //已经找到开始位置，end也有初值了，然后找到了第一个大于target的元素，则end取i的前一个位置
                end = i-1;
                break;
            }else if(end>=0&&i==nums.length-1){
                //已经找到开始位置，end也有初值了，然后一直到末尾都找不到大于target的元素，end在最后
                end = i;
            }
        }
        int[] result = {begin,end};
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {2,2};
        solution.searchRange(nums,2);
    }
}
