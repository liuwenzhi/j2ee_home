package lkhwtk.mst1626;

import java.util.Stack;

/**
 * 面试题 16.26. 计算器
 */
public class Solution {
    public int calculate(String s) {
        int length = s.length();
        //数字临时记录变量
        int num = 0;
        //前置计算符号
        char preSign = '+';
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<length;i++){
            char c = s.charAt(i);
            //如果当前字符是数字，注意：数字可能是连续的
            if(Character.isDigit(c)){
                num = num*10 + (c - '0');
            }
            //当前字符是运算符号，需要在最后把num归零，同时遍历到最后一个数字的时候，需要进行一次计算（对应条件：i==length-1）
            if(!Character.isDigit(c)&&c!=' '||i==length-1){
                switch(preSign){
                    case '+':stack.push(num);
                        break;
                    case '-':stack.push(-num);
                        break;
                    case '*':stack.push(stack.pop()*num);
                        break;
                    case '/':stack.push(stack.pop()/num);//注意：这里是pop出来的元素/num，num在后边
                        break;
                }
                num=0;
                preSign = c;
            }
        }
        //循环外边对stack中的元素累加一遍
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;

    }
}
