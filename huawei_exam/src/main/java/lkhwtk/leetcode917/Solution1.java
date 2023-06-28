package lkhwtk.leetcode917;

import java.util.Stack;

/**
 * 官方使用栈的实现思路可以参考下，执行耗时会更多一点
 */
public class Solution1 {
    public String reverseOnlyLetters(String s) {
        Stack<Character> letters = new Stack();
        for (char c: s.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }

        return ans.toString();
    }
}
