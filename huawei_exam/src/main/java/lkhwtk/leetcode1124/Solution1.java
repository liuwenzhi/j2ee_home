package lkhwtk.leetcode1124;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1124. 表现良好的最长时间段
 * 参考题解：下边几个题解配合起来看
 * 前缀和+单调栈 Python3
 * 表现良好的最长时间段（暴力 / 单调栈 + 前缀和☀）（单调栈再看） 这个题解中看下边的回复，单调栈代码是有问题的。
 * 参考了几个大神的题解之后总结下来非常详细的解题思路, 希望大家少走些弯路.
 * 本题算法过于抽象，可以背一下这个思路
 */
public class Solution1 {
    public int longestWPI(int[] hours) {
        //创建一个1和-1组成的数组，标识时间是否超过了8小时
        int n = hours.length;
        int[] score = new int[n];
        for (int i=0;i<n;i++) score[i] = hours[i] > 8 ? 1 : -1;
        //计算前缀和，注意前缀和数组长度比score数组长度大1
        int[] presum = new int[n + 1];
        presum[0] = 0;
        for (int i=1;i<n+1;i++) {
            presum[i] = presum[i - 1] + score[i - 1];
        }
        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        //存放初始元素的前缀和
        stack.addLast(0);
        //维护一个单调栈，存放presum数组中元素的索引，设计存储到里边的元素严格单调递减，
        for (int i=1;i<n;i++) {
            //注意：算法中的栈是通过LinkedList来实现，peekLast实际是获取栈顶元素（presum数组中的索引）
            if (stack.isEmpty() || presum[stack.peekLast()] > presum[i]) {
                //栈中索引指向的元素严格单调递减
                stack.addLast(i);
            }
        }
        //从后往前遍历 presum 数组
        for (int i=n;i>=0;i--) {
            //说明栈顶索引到i位置的和是大于0的，是表现良好的时间段
            while(!stack.isEmpty() && presum[i] > presum[stack.peekLast()]) {
                //与栈顶索引指向元素比较，如果相减结果大于 0，则一直出栈，直到不大于 0 为止，然后更新当前最大宽度
                result = Math.max(result, i - stack.pollLast());
            }
        }
        return result;

    }
}
