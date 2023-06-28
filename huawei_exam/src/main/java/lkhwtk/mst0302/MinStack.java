package lkhwtk.mst0302;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题 03.02. 栈的最小值
 * 参考题解：【辅助栈】栈的最小值，这个图说明很不错。
 * 本题同主栈155题
 */
public class MinStack {

    /**私有主栈属性*/
    private Deque<Integer> stack;

    /**私有最小栈属性*/
    private Deque<Integer> minStack;

    /** 初始化栈 */
    public MinStack() {
        this.stack = new LinkedList<>();
        this.minStack = new LinkedList<>();
    }

    /**
     * 入栈，做一个最小值变更
     */
    public void push(int x) {
        stack.push(x);
        //minstack存储的是当前剩余全部元素的最小值，里边的值可能有重复的
        if(minStack.isEmpty()){
            minStack.push(x);
        }else{
            minStack.push(Math.min(minStack.peek(),x));
        }
    }

    /**
     * 出栈，做一个最小值变更
     */
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
