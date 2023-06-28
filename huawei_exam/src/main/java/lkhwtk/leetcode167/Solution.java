package lkhwtk.leetcode167;

/**
 * 167. 两数之和 II - 输入有序数组
 *思路参考：两数之和 II - 输入有序数组 - 双指针 O(N) 时间复杂度
 * 核心思路：双指针，一个头一个尾，结果打了右指针左移，小了左指针右移。本题数组是排过序的，这一点和第一题不同
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for(int i=0,j=numbers.length-1;i<numbers.length-1&&j>0;){
            if(numbers[i]+numbers[j]<target){
                i++;
            }else if(numbers[i]+numbers[j]>target){
                j--;
            }else{
                result[0] = ++i;
                result[1] = ++j;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int a[] = {2,3,4};
        int target = 6;
        Solution solution = new Solution();
        solution.twoSum(a,target);
    }
}
