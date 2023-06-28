package lkhwtk.leetcode88;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 合并两个有序数组
 * 本题投机取巧做法，注意本题的提示信息：nums1.length=m+n，m是nums1的元素数量
 * 本题同面试题1001
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
