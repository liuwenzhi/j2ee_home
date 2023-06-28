package lkhwtk.leetcode394;

import java.util.LinkedList;

/**
 * 394. 字符串解码
 * 解题思路参考：字符串解码（辅助栈法 / 递归法，清晰图解）
 */
public class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        //数字只会出现在左括号前，初始化为0，数字可能不只有1位，可能是2位3位的更大的数字
        int num = 0;
        //数字栈
        LinkedList<Integer> stack_num = new LinkedList<>();
        //字符串结果栈
        LinkedList<String> stack_res = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            if(c == '[') {
                //遇到左括号，把数字压进栈
                stack_num.push(num);
                stack_res.push(res.toString());
                //重置数字为0
                num = 0;
                //重置结果res
                res = new StringBuilder();
            }else if(c == ']') {
                //遇到右括号，从数字栈中弹出近的数字
                StringBuilder tmp = new StringBuilder();
                int cur_num = stack_num.poll();
                for(int i = 0; i < cur_num; i++) {
                    tmp.append(res);
                }
                //res之前的字符串和当前重复的字符串再拼接一次
                res = new StringBuilder(stack_res.pop() + tmp);
            }else if(c >= '0' && c <= '9'){
                //如果遇到数字，就进行数字的累加
                num = num * 10 + Integer.parseInt(c + "");
            }
            else{
                //普通字母拼接到res上
                res.append(c);
            }
        }
        return res.toString();
    }
}
