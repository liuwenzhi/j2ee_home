package lkhwtk.leetcode373;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 373. 查找和最小的K对数字
 * 参考题解：查找和最小的K对数字
 * 思路一：暴力解法，内存会超范围，也可以参考下，二维数组排序这块代码不错
 */
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        List<List<Integer>> result = new ArrayList<>();


        if (n1 == 0 || n2 == 0 || k == 0) return result;

        int[][] arr = new int[n1 * n2][2];
        int idx = 0;

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                arr[idx][0] = nums1[i];
                arr[idx][1] = nums2[j];
                idx++;
            }
        }

        Arrays.sort(arr, (o1, o2) -> (o1[0] + o1[1]) - (o2[0] + o2[1]));

        for (int i = 0; i < Math.min(k, arr.length); i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(arr[i][0]);
            temp.add(arr[i][1]);
            result.add(temp);
        }

        return result;

    }

    public static void main(String[] args){
        //二维数组按照元素之和从小到大排序
        int[][] arr = {{1,2},{0,1}};
        Arrays.sort(arr, (o1, o2) -> (o1[0] + o1[1]) - (o2[0] + o2[1]));
        System.out.println("哈哈");

    }
}
