package lkhwtk.leetcode350;

import java.util.Arrays;

/**
 * 350. 两个数组的交集 II
 * 核心思路：归并求交集
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] temp = new int[Math.min(nums1.length,nums2.length)];
        int index = 0;
        for(int i=0,j=0;i<nums1.length&&j<nums2.length;){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                temp[index] = nums1[i];
                i++;j++;index++;
            }
        }
        int[] result = new int[index];
        for(int i=0;i<index;i++){
            result[i] = temp[i];
        }
        return result;
    }

    public static void main(String[] args){

    }
}
