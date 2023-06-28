package lkhwtk.leetcode275;

/**
 * 官方二分查找题解，效率能更高一点，二轮复习看下
 */
public class Solution1 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //引用次数大于剩余元素数
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //最终left位置指向了数组中第一个引用次数大于剩余元素数量的位置，h为n-left
        return n - left;
    }
}
