package lkhwtk.leetcode946;

import java.util.Stack;

/**
 * 946. 验证栈序列
 * 参考题解：验证栈序列 官方
 * 核心思路：贪心
 * 非常聪明的解法
 * 本题同offer31题
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack();
        int j = 0;
        //将pushed数组中每一个元素都入栈，然后在元素入栈的过程中，不断判断是否栈顶元素是poped数组j位置的元素，是的话，stack弹出元素，j++
        for (int x: pushed) {
            stack.push(x);
            //peek方法：获取头元素，但是不移除它
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        //最后判断j是否走到了popped数组最后
        return j == N;
    }
}
