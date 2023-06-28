package lkhwtk.leetcode88;

/**
 * 核心思路：借助归并的方式，先把nums1拷贝出来，再把新数组和num2以归并的方式放到nums1中
 * 省事
 */
public class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //注意：m是元素数量，不是nums1的长度
        int[] temp = new int[m];
        for(int i=0;i<m;i++){
            temp[i] = nums1[i];
        }
        int i,j,tmp=0;
        for(i=0,j=0;i<m&&j<n;){
            if(temp[i]<nums2[j]){
                nums1[tmp++] = temp[i++];
            }else{
                nums1[tmp++] = nums2[j++];
            }
        }
        while(i<m){
            nums1[tmp++] = temp[i++];
        }
        while(j<n){
            nums1[tmp++] = nums2[j++];
        }
    }
}
