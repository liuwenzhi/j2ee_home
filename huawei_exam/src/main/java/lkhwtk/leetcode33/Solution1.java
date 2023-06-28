package lkhwtk.leetcode33;

/**
 * 采用二分法设置的时间复杂度为o(logN)的解决方案
 * 参考题解：官方
 * 搜索旋转排序数组 - Java
 */
public class Solution1 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        //数组长度为0，返回-1
        if (n == 0) {
            return -1;
        }
        //数组长度等于1，直接判断唯一元素和target是否相等
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        //双指针，一头一尾
        int l = 0, r = n - 1;
        while (l <= r) {
            //中间位置
            int mid = (l + r) / 2;
            //中间位置元素直接就是target，返回这个位置
            if (nums[mid] == target) {
                return mid;
            }
            //通过nums[mid]和前后两个端点进行比较，前后两个部分肯定有一个部分是有序的，nums[mid]比前端点大说明前半部分有序，否则说明后半部分有序
            if (nums[0] <= nums[mid]) {
                //前半部分有序
                if (nums[0] <= target && target < nums[mid]) {
                    //前半部分有序，并且target在前半部分，则缩小搜索范围在前半部分
                    r = mid - 1;
                } else {
                    //前半部分有序，并且target在后半部分
                    l = mid + 1;
                }
            } else {
                //后半部分有序
                if (nums[mid] < target && target <= nums[n - 1]) {
                    //后半部分有序，并且target在后半部分，则缩小搜索范围在后半部分
                    l = mid + 1;
                } else {
                    //后半部分有序，并且target在前半部分
                    r = mid - 1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args){
        Solution1 solution = new Solution1();
        int[] nums = {7,0,1,2,4,5,6};
        solution.search(nums,3);
    }
}
