package lkhwtk.leetcode402;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. 移掉K位数字
 * 核心思路：贪心+单调栈(算法基于队列实现，方便从前后存入和取出数据)
 * 参考题解：官方题解，精选题解：一招吃遍力扣四道题，妈妈再也不用担心我被套路啦～
 * 2021年8月30日二轮刷题记录：重点参考官方题解，别拉下官方题解中给出的需要额外处理的内容，非常细。
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        //用deque模拟一个单调栈，里边元素在满足删除k的情况下递增存放
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            //deque.peekLast() 获取队列末尾元素和当前digit比较，以425为例，4先进队尾，然后2来了，和4比较，4比2大，4出队，2进队
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                //从队列后端删除元素 14->删除4后变成1
                deque.pollLast();
                k--;
            }
            //从队列后端插入记录
            deque.offerLast(digit);
        }

        //在经过上一步删除元素之后，有可能删除的元素数量达不到k，如果还能继续移除数字，则每次移除最末尾
        //删除末尾的原因是：经过移动，已经保证deque栈中是一个单调递增的序列了，最大的数都在最后几位，从最后一个开始统统干掉
        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        //基于deque里边的元素拼接字符串，注意：删除元素之后，可能存在数字开头为0的情况，比如例题中10200，如果开头存在一位或者多位是0
        //则直接跳过，一直到开头找到了不是0的位，再置连续0标记（leadingZero）为false，拼接省下的字符
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            //pollFirst()获取队列头元素：0123 获取 0，这里做一个特殊处理：移除元素之后，数字前边几位可能为0
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                //如果移除元素后，前边都是连续0，则一直循环
                continue;
            }
            //连续0的标志位置为false
            leadingZero = false;
            ret.append(digit);
        }
        //最后返回也注意下，可能结果时空字符串，即所有元素都移除了，这个时候返回一个0
        return ret.length() == 0 ? "0" : ret.toString();

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.removeKdigits("1432219",3);
    }
}
