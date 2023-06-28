package lkhwtk.leetcode350;

import java.util.Arrays;

/**
 * 老思路优化
 * 最后借助Arrays占用空间大了一点
 */
public class Solution1 {
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
        //从0位置开始拷贝，一直到index，前闭后开
        return Arrays.copyOfRange(temp, 0, index);
    }
}
