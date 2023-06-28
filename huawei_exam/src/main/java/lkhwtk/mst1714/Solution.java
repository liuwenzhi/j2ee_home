package lkhwtk.mst1714;

import java.util.Arrays;

/**
 * 面试题 17.14. 最小K个数
 * 个人思路
 */
public class Solution {
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = arr[i];
        }
        return result;
    }
}
