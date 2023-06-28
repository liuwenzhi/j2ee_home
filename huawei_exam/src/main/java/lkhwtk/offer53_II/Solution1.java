package lkhwtk.offer53_II;

/**
 * 采用折半查找思路（二分查找）
 * 思路很巧妙，还是利用了数组是递增的特点，如果这中间元素值和数组下标相等，则说明确实的在中间元素后边位置，
 * 否则说明在中间元素之前，按照代码中的逻辑，重复查找过程，直到右指针走到了左指针左边
 */
public class Solution1 {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        //注意二分查找条件是left<=right的情况，i=mid+1,j=mid-1
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) {
                i = m + 1;
            }else{
                j = m - 1;
            }
        }
        return i;
    }

    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        int[] a = {0,1,2,3,4,5,6,7,9};
        solution1.missingNumber(a);
    }
}
