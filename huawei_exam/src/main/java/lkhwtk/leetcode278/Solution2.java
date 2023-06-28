package lkhwtk.leetcode278;

/**
 * 遇到双指针的问题，注意边界，可以拿一个简单的数组试试
 * 本题用Solution1不行，直接上Solution2，二分查找就这两种情况，试出来就好
 */
public class Solution2 extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出，很好的设计
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }
}
