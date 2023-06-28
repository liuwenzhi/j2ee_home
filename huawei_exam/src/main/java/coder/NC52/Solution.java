package coder.NC52;
import java.util.Stack;

/**
 * NC52 括号序列
 * 本题同leetcode20
 */
public class Solution {
    public boolean isValid (String s) {
        // write code here
        Stack<Character> c = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            if(c.empty()){
                c.push(s.charAt(i));
                continue;
            }
            if(s.charAt(i)==')'&&c.peek()=='('){c.pop();}
            else if(s.charAt(i)=='}'&&c.peek()=='{'){c.pop();}
            else if(s.charAt(i)==']'&&c.peek()=='['){c.pop();}
            else{ c.push(s.charAt(i));}
        }
        return c.empty();
    }
}
