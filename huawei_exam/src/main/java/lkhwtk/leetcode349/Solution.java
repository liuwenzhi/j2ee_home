package lkhwtk.leetcode349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * 个人思路
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        for(int i=0,j=0;i<nums1.length&&j<nums2.length;){
            if(nums1[i]==nums2[j]){
                set.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        //set集合转成一个整形数组，后边看看有没有更好的方式转换
        int[] intersection = new int[set.size()];
        int index = 0;
        for (int num : set) {
            intersection[index++] = num;
        }
        return intersection;
    }
}
