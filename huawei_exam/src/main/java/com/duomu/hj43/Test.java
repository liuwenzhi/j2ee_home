package com.duomu.hj43;

import java.util.*;

/**
 * 注意Stack和LinkedList两种栈的使用的区别，Stack有add方法，也有push方法，都是压入栈，后进先出
 * LinkedList的add和offer方法都是从后边插入元素，poll也是按照从前到后的方式，使用LinkedList如果实现
 * 栈的效果，需要使用push压栈的方式
 * todo 重点看下Test0说明
 */
public class Test {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("^^^--------------stack add（1234）的pop输出：4321---------------");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("^^^--------------stack push（1234）的pop输出:4321---------------");
        //采用LinkedList模拟栈的形式
        Deque<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println("^^^--------------LinkedList模拟栈 add(1234)的poll输出:1234---------------");
        queue.clear();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println("^^^--------------LinkedList push(1234)的poll输出:4321---------------");
        queue.clear();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println("^^^---------------LinkedList offer(1234)的poll输出:1234---------------");

    }
}
