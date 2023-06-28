package lkhwtk.leetcode20;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 备注：本题提交执行没有问题，执行代码那个按钮执行结果有问题，不用管。
 * 思路非常不错
 */
public class Solution {
    public boolean isValid(String s) {
        //思路：借助于栈实现，遇见左括号就把对应的右括号入栈，如果是右括号则弹出栈顶元素进行比对
        Stack<Character> stack = new Stack();
        //元素数必须是偶数
        if (s.length() % 2 != 0) {
            return false;
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else {
                //如果有右括号而没有匹配的左括号则失败，如果弹出的栈顶元素和对应的右括号不匹配则失败
                if(stack.isEmpty()||stack.pop()!=c){
                    return false;
                }
            }
        }

        //遍历结束之后，栈中还有数据，则肯定没匹配上
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.isValid("0"));
    }
}
