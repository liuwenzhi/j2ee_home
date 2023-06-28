package lkhwtk.leetcode155;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 * 本题和面试题0302是同一题
 */
public class MinStack {

    /**私有主栈属性*/
    private Deque<Integer> stack;

    /**私有最小栈属性*/
    private Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new LinkedList<>();
        this.minStack = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
        //minstack存储的是当前剩余全部元素的最小值，里边的值可能有重复的
        if(minStack.isEmpty()){
            minStack.push(val);
        }else{
            minStack.push(Math.min(minStack.peek(),val));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
