package lkhwtk.leetcode278;

/**
 * Solution1是对solution2的一种变形，并不能说这种方式更好,while条件和if判断
 * 这个边界有一点不同，实际多移动了一次
 */
public class Solution1 extends VersionControl{
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left <= right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出，很好的设计
            if (isBadVersion(mid)) {
                right = mid - 1; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left > right
        return left;
    }
}
