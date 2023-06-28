package lkhwtk.mst1626;

import java.util.Stack;

/**
 * 参考题解：【数据结构和算法】使用栈解决，视频演示
 * 这个算法效率比个人的效率要高，核心思路一致
 */
public class Solution1 {
    public int calculate(String s) {
        //记录每个数字前面的符号，如果是乘法和除法就直接和前面的数字运算，
        //然后在存放到栈中，如果是加法和减法直接存放到栈中
        int preSign = '+';
        Stack<Integer> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int ch = s.charAt(i);
            if (ch == ' ')//过滤掉空格
                continue;
            //如果是数字
            if (ch >= '0' && ch <= '9') {
                //找到连续的数字字符串，把它转化为整数
                int num = 0;
                while (i < length && (ch = s.charAt(i)) >= '0' && ch <= '9') {
                    num = num * 10 + ch - '0';
                    i++;
                }
                //这个是为了抵消上面for循环中的最后一次i++，自增之后不满足条件了
                i--;
                //乘法和除法，运算之后在存放到栈中。加法和减法直接存放到栈中
                if (preSign == '*') {
                    stack.push(num * stack.pop());
                } else if (preSign == '/') {
                    stack.push(stack.pop() / num);
                } else if (preSign == '+') {
                    stack.push(num);
                } else if (preSign == '-') {
                    stack.push(-num);
                }
            } else {//记录前一个的符号
                preSign = ch;
            }
        }
        //把栈中的所有元素都取出来，计算他们的和
        int res = 0;
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;

    }
}
