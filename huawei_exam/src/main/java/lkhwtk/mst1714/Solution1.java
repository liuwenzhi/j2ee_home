package lkhwtk.mst1714;

import java.util.Arrays;

/**
 * 快速排序，效率非常高
 * 参考题解：快排序，一个模板送给大家,非常精简。
 * 备注：快速排序的核心思路：找到枢轴，每次移动元素，让枢轴左侧都是比枢轴值小的元素，右侧都是比枢轴值大的元素
 */
public class Solution1 {
    public int[] smallestK(int[] arr, int k) {
        int n = arr.length;
        return quick_sort(arr, 0, n - 1, k);
    }
    /**
     * @param a 待排序数组
     * @param l 左侧边界
     * @param r 右侧边界
     * @param k 结果长度
     */
    public int[] quick_sort(int[] a, int l, int r,  int k){
        if(l >= r) return new int[]{};
        int i = l - 1, j = r + 1;
        int x = a[l];

        while(i < j)
        {
            do i ++; while( x > a[i]);
            do j --; while( x < a[j]);
            if(i < j)
            {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        if(j + 1 < k) quick_sort(a, j + 1, r, k);
        if(j + 1 > k) quick_sort(a, l, j, k);
        return Arrays.copyOf(a, k);
    }

}
