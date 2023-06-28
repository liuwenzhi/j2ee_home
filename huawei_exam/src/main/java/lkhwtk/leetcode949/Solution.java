package lkhwtk.leetcode949;

/**
 * 949. 给定数字能组成的最大时间
 * 参考题解：官方，核心思路：暴力
 * 本题数组A中实际只有4个元素，所以用暴力解法不会很花时间，就是4个位置的组合
 */
public class Solution {
    public String largestTimeFromDigits(int[] A) {
        int ans = -1;
        //下标i, j, k, l作为第 0、1、2、3位排列编号
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                //注意：暴力遍历的时候，需要保证时间信息四个数字是A中不同的位置上的数字
                if (j != i) {
                    for (int k = 0; k < 4; ++k) {
                        //k元素的位置需要和i、j都不相同
                        if (k != i && k != j) {
                            //A中有四个元素，实际需要四层for循环，作为元素编号0,1,2,3来说，确定了三个编号的元素，最后一个用6-前三个编号之和即可
                            int l = 6 - i - j - k;
                            //对于每一个A[i]的排列，拼出合法时间，并记录最大合法四件
                            int hours = 10 * A[i] + A[j];
                            int mins = 10 * A[k] + A[l];
                            //如果小时和分钟都满足条件，那么把小时转成分钟和分钟累加，比较这个历史值，找到最大的
                            if (hours < 24 && mins < 60)
                                ans = Math.max(ans, hours * 60 + mins);
                        }
                    }
                }
            }
        }
        //%02d 格式化为至少2位十进制整数
        return ans >= 0 ? String.format("%02d:%02d", ans / 60, ans % 60) : "";
    }
}
