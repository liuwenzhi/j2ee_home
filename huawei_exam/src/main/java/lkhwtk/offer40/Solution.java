package lkhwtk.offer40;

import java.util.Arrays;

/**
 * 剑指 Offer 40. 最小的k个数
 * 本题可以参考下这个解：剑指 Offer 40. 最小的k个数
 * 快速排序和计数方式效率较高
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        Arrays.sort(arr);
        for(int i=0;i<k;i++){
            result[i] = arr[i];
        }
        return result;
    }
}
