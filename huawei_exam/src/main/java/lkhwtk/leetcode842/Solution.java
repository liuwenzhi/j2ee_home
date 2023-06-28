package lkhwtk.leetcode842;

import java.util.ArrayList;
import java.util.List;

/**
 * 842. 将数组拆分成斐波那契序列
 * 参考了306题思路
 */
public class Solution {

    private List<Integer> result;
    public List<Integer> splitIntoFibonacci(String num) {
        result = new ArrayList<>();
        dfs(num, num.length(), 0, 0, 0, 0);
        return result;
    }

    /**
     * @param num    原始字符串
     * @param len    原始字符串长度
     * @param idx    当前处理下标
     * @param sum    前面的两个数字之和
     * @param pre    前一个数字
     * @param k      当前是处理的第几个数字
     * 递归算法中，重复执行了for循环内容，但是实际上，每一次递归，很大概率上没有把for都走完，走了其中几位，
     * 在递归过程中每一次进入for循环的时候，在拿到了cur==sum之后，就进入下一层递归，idx后移几位，到最后有
     * 返回值之后，一层一层直接返回。这个递归实际效率很低的，应该是测试用例没有大的数据量
     */
    private boolean dfs(String num, int len, int idx, long sum, long pre, int k) {
        //递归出口条件：当遍历完最后数组中一个元素之后，必须的是处理了超过2个数字，才能保证有前两数字之和等于第三个数字
        //基于算法的设计，不会出现到了最后一个元素之后，之前不满足累加的情况，能走进if判断里边，肯定是前边都满足条件了
        if (idx == len) {
            return k > 2;
        }
        for (int i = idx; i < len; i++) {
            //从字符串中截取当前数字，长度可能是1位，可能是多位
            long cur = fetchCurValue(num, idx, i);
            // 剪枝：负数或者拆出来的数字大于整形最大值，则直接返回false，注意题目中这个信息：0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）
            if (cur < 0||cur>Integer.MAX_VALUE) {
                return false;
            }
            // 剪枝：当前数字不等于前面两数之和
            if (k >= 2 && cur != sum) {
                continue;
            }
            if (dfs(num, len, i + 1, pre + cur, cur, k + 1)) {
                result.add(0,Integer.parseInt(cur+""));
                return true;
            }
        }
        //这个返回非常必要，不能少
        return false;
    }

    /**
     * 获取一个字符串num从左边l位置到右边r位置全部字符组成的合法数字
     */
    private long fetchCurValue(String num, int l, int r) {
        //注意：算法中入参的l和r可能是相等的，如果是l和r一左一右，同时左边以0开头，肯定不满足条件
        if (l < r && num.charAt(l) == '0') {
            return -1;
        }
        long res = 0;
        //注意左右位可能相等
        while (l <= r) {
            res = res * 10 + num.charAt(l++) - '0';
        }
        return res;
    }

}
