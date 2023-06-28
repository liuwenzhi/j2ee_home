package lkhwtk.leetcode856;

import java.util.Stack;

/**
 * 856. 括号的分数
 * 注意本题得分规则，不是纯深度问题，本题基于栈实现是一个很固定的算法，参考官方图解。
 * 参考题解：括号的分数 官方
 */
public class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack();
        //初始插入一个0值，后边出栈计算会用到
        stack.push(0);

        for (char c: S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }
        return stack.pop();

    }
}
