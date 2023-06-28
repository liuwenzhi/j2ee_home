package lkhwtk.leetcode150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 150. 逆波兰表达式求值
 * 参考题解:官方，老题了，牛客网就见过。
 * 核心思路：借助一个栈：遍历表达式，数字就压栈，如果是运算符则弹出栈顶两个元素进行计算，
 * 计算完成之后再把结果压栈，本题不涉及附加的括号和正负号等，相对能容易一点点
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            //数字就入栈
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                //操作符就弹出栈顶两个元素进行计算，再把计算结果压栈，注意：出栈顺序和压栈顺序是反的，这里一定是先拿到num2，再拿到num1
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        //最后栈中剩余一个结果
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
