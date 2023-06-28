package lkhwtk.leetcode225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * 直接看官方题解
 */
public class MyStack {

    //queue1是主队列
    Queue<Integer> queue1;
    //queue2是辅助队列
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        //元素从后端入队，插入元素先放辅助队列，然后再把主队列中元素都添加到辅助队列，最后主队列和辅助队列引用互换
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
