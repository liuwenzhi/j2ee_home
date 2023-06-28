package lkhwtk.leetcode34;

/**
 * 折半查找（二分查找）
 */
public class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        //条件设置为<=，配合lower这个条件，在测试数据中，left首次选中了第二个8，此时ans=4，left=right=3
        //接下来还会在执行一遍循环，mid=3，然后nums[mid]=3。如果是找右边界，lower=false，最终会找到target之后的一个元素位置
        while (left <= right) {
            int mid = (left + right) / 2;
            //计算leftIdx时lower为true，计算rightIdx时low儿为false，这一步设计很巧妙
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] a = {5,7,7,8,8,10};
        Solution1 solution = new Solution1();
        System.out.println(solution.searchRange(a,8));
    }


}
