package lkhwtk.leetcode921;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 921. 使括号有效的最少添加
 * 个人思路，可参考leectode22题和leetcode20题
 */
public class Solution {
    public int minAddToMakeValid(String s) {
        int result = 0;
        if(s==null||"".equals(s.trim())){
            return result;
        }
        Deque<Character> stack = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //如果是左括号，就入栈
            if(c=='('){
                stack.push('(');
            }else{
                //如果是右括号，确认是否能从栈中弹出左括号，与之匹配，只需要判断栈是否为空
                if(stack.isEmpty()){
                    //此时没有匹配的左括号
                    result++;
                }else{
                    //能够匹配上就弹出栈顶元素
                    stack.pop();
                }
            }
        }
        //最后再统计下栈中还剩几个左括号
        result+=stack.size();
        return result;
    }
}
