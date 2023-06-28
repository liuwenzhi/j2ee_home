package lkhwtk.offer30;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 参考题解：面试题30. 包含 min 函数的栈（辅助栈，清晰图解） 精选
 * 备注：pop:获取并弹出栈顶元素，peek：获取不弹出栈顶元素
 * 本题同主栈155题
 */
public class MinStack {

    /**主栈*/
    Stack<Integer> stackA = null;
    /**辅栈，辅助栈栈顶元素存储A中剩余数据的最小元素*/
    Stack<Integer> stackB = null;

    /**构造函数初始化主栈和辅栈*/
    public MinStack() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    /**向队列中加元素的方法，注意：这里使用push和add效果一致*/
    public void push(int x) {
        stackA.push(x);
        //算法最核心点在这里：如果入栈元素比B的栈顶大，元素不进入辅助栈，因为此时入栈元素肯定不是最小的，就算A栈中pop出了这个元素，对A栈中最小值没有影响
        if(stackB.isEmpty()||stackB.peek()>=x){
            stackB.push(x);
        }
    }

    /**弹出元素，结合push的思路，A栈先弹出元素，如果B栈栈顶元素等于A栈弹出元素，B栈才弹出元素*/
    public void pop() {
        if(stackA.pop().equals(stackB.peek())){
            stackB.pop();
        }
    }

    /**获取主栈栈顶元素*/
    public int top() {
        return stackA.peek();
    }

    /**获取辅助栈的栈顶元素*/
    public int min() {
        return stackB.peek();
    }

    /**
     * main方法中验证下对于stack栈，add和push的效果一直，add是stack的父类vector中的方法，
     * 每次添加到集合的最后，能够达到push的效果。可参考下这个说明：
     * https://blog.csdn.net/panda_In5/article/details/77235627
     */
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
