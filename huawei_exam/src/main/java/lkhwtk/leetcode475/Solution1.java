package lkhwtk.leetcode475;

import java.util.Arrays;

/**
 * 参考题解：供暖器（Java）
 * 题解中对于二分查找的使用说明和比较条件说明很细致，本题用暴力搜能搞定，
 * 二分查找后边边界问题很不好理解，二分查找的边界就两种情况，if<=mid，right=mid+1或者if<mid,right=mid，涉及到二分查找直接试一下就完了。
 * 本题解相对于本人的题解，就是把内层循环改成二分查找，效率提高了很多
 */
public class Solution1 {
    public int findRadius(int[] houses, int[] heaters) {
        int radius = 0;
        int n = heaters.length;
        //房屋和取暖器的顺序按理说应该是顺序摆放的，做下排序没问题
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for (int house: houses) {
            int left = 0;
            int right = n;
            // 寻找最后一个不大于或者第一个不小于目标值（也就是house）的值
            // 区别在于最后的返回值是right还是right-1
            // 下面是查找第一个不小于house的值
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (heaters[mid] < house) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // 通过right，也就是右侧收敛的情况来判断是左侧还是右侧的最近的heater，当前房子左边或者右边最近的取暖器
            int rightDist = (right == n) ? Integer.MAX_VALUE : Math.abs(house - heaters[right]);
            int leftDist = (right == 0) ? Integer.MAX_VALUE : Math.abs(house - heaters[right - 1]);
            radius = Math.max(radius, Math.min(rightDist, leftDist));
        }
        return radius;
    }

}
