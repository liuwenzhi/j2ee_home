package lkhwtk.Offer_58_I;

import java.util.Stack;

/**
 * 基于栈实现
 * 注意：stack不能像Solution2中那样处理，那样会保证字符串的顺序，而这里主要是使用stack的逆序输出
 */
public class Solution1 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] arr = s.split("\\s+");
        for (String str : arr) {
            stack.push(str);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        return sb.toString().trim();
    }
}
