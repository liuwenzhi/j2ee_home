package lkhwtk.leetcode921;

import java.util.Stack;

/**
 * 基于Stack实现栈
 */
public class Solution1 {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int count = 0;

        Stack<Character> stack = new Stack<>();

        for (int i=0;i<n;i++) {

            if (s.charAt(i) == '(') {

                stack.push('(');
            }
            if (s.charAt(i) == ')') {

                if (!stack.isEmpty()) {

                    stack.pop();
                } else {

                    count++;
                }
            }
        }
        if (stack.isEmpty()) return count;
        else return stack.size() + count;

    }
}
