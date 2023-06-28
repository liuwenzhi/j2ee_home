package lkhwtk.offer31;

import java.util.Stack;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * 非常巧的思路，本题同946题
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
