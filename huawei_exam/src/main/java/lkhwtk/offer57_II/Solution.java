package lkhwtk.offer57_II;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 参考题解：什么是滑动窗口，以及如何用滑动窗口解这道题
 * 题解中对滑动窗口基本概念解析非常好
 */
public class Solution {
    public int[][] findContinuousSequence(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                //右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                //左边界向右移动
                sum -= i;
                i++;
            } else {
                //记录结果，注意结果是i到j-1，每次右边界扩展，统计完和之后，j自增了，如果此时满足条件，不应该把j统计进去
                //而左侧边界，如果i自增之后满足了条件，则需要包括i，因为是自增之后的才满足条件，注意这个和之前判断回文数的模板不同，那个是左右指针都往两边移动，
                //本题是滑动窗口，左右指针往同一侧移动
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                //i从1开始，找完1的序列，从这个序列的下一个开始位置执行
                i++;
            }
        }
        //注意：将List列表，泛型是一维数组转成二维数组的方式，这个比较通用
        return res.toArray(new int[res.size()][]);
    }
}
