package lkhwtk.leetcode1190;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1190. 反转每对括号间的子串
 * 参考题解：官方
 * 本题算法不复杂，稍微有点绕，作为一个模板记一下吧
 */
public class Solution {
    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                //压入栈顶
                stack.push(sb.toString());
                //sb.setLength(0)相当于清空了sb里边的记录
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                //在开头插入stack栈的栈顶元素，保证插入的是当前字符串左括号前边最近的一个字符串
                sb.insert(0, stack.pop());
            } else {
                //不是左右括号就拼接字符
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.reverseParentheses("(ed(et(oc))el)"));
        //System.out.println(solution.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
}
