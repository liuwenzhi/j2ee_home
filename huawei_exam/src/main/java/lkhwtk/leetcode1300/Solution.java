package lkhwtk.leetcode1300;

/**
 * 1300. 转变数组后最接近目标值的数组和
 * 参考题解：二分查找（附相关练习），注意：本题对二分查找的使用有一些变形，不是想像之前思路那样，针对于
 * 一个数组里边的元素进行二分查找，而是从0开始，到这个数组中最大的元素，left和right之间的mid元素，这个mid，
 * 不是数组的下标，也不是数组中的元素，就是从0到数组的最大元素之间的一个mid值，然后按照题目要求，计算下数
 * 组的和，因为计算涉及到四舍五入，所以最终定位left之后，比对下left和left-1位置，看看哪一个更接近，替换成
 * left是刚刚好大于target，left是刚刚好小于target，再做一次比对
 */
public class Solution {
    public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = 0;
        //left设置为0，right是arr数组中最大的元素
        for (int num : arr) {
            right = Math.max(right, num);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = calculateSum(arr, mid);
            // 计算第 1 个使得转变后数组的和大于等于 target 的阈值 threshold
            if (sum < target) {
                //最终的left结果是刚好大于target的
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // 比较阈值线分别定在 left - 1 和 left 的时候与 target 的接近程度
        int sum1 = calculateSum(arr, left - 1);
        int sum2 = calculateSum(arr, left);
        if (target - sum1 <= sum2 - target) {
            return left - 1;
        }
        return left;
    }

    private int calculateSum(int[] arr, int threshold) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.min(num, threshold);
        }
        return sum;
    }

    /**
     * main方法验证一下，二分查找的目标值如果不在数组中，则按照二分查找的两个模板，最后找到的结果都是刚刚大于目标值的元素位置
     * 此题中，两个模板输出都是位置5上的元素6
     */
    public static void main(String[] args){
        int[] a = {0,1,2,3,4,6,7,8,9};
        int target = 5;
        int left = 0;
        int right = a.length-1;
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(a[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(a[left]);
    }
}
