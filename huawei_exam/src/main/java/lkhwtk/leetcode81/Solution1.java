package lkhwtk.leetcode81;

/**
 * 参考题解：官方
 * 本题是对二分查找的变形，二分查找的前提是必须是排序好的数组，这里就是要找到哪里有序。
 * 按照题解记一下算法的思路
 * 本题是对33题的变形，增加了重复数据的情况
 */
public class Solution1 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {//相对于33题来说，存在重复元素，可能会导致确定不了区间是否是
                ++l;
                --r;
            } else if (nums[l] <= nums[mid]) {//左半区有序，判断元素是否在这个半区中
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {//右半区有序，判断元素是否在这个半区中
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

}
