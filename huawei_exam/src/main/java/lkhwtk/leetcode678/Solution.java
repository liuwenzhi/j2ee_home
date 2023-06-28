package lkhwtk.leetcode678;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 678. 有效的括号字符串
 */
public class Solution {
    public boolean checkValidString(String s) {
        //如果s以)开始，则肯定返回false
        if(s.startsWith(")")){
            return false;
        }
        //定义两个栈，一个存放(的下标，一个存放*的下标
        Deque<Integer> leftStack = new LinkedList<>();
        Deque<Integer> starStack = new LinkedList<>();
        //先判断下右括号入栈是否能有匹配的左括号和*
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                leftStack.push(i);
            }else if(c=='*'){
                starStack.push(i);
            }else{
                //右括号的情况
                if(!leftStack.isEmpty()){
                    leftStack.pop();
                }else if(!starStack.isEmpty()){
                    starStack.pop();
                }else{
                    return false;
                }
            }
        }
        if (starStack.size() < leftStack.size()){
            //当字符串全部遍历完时，星比左括号少报错，星可以大于左括号（多余的代表空字符）
            return false;
        } else {
            while (!starStack.isEmpty() && !leftStack.isEmpty()) {
                //在确认了星号数量大于等于左括号的情况下，（在*的左边才可以，这个设计很巧，直接取元素坐标，注意：之前是压栈，栈顶元素都是后边的
                if (starStack.peek() < leftStack.peek()) {
                    return false;
                }
                starStack.pop();
                leftStack.pop();
            }
            return true;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())");
    }
}
