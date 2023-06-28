package com.duomu.hj43;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test0 {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        //这里如果把stack元素pop出去，得到的结果是4 3 2 1，但是如果这里直接pop出去之后，后边创建list列表就没有数据了
        List<Integer> list = new ArrayList<>(stack);
        for(Integer i:list){
            //注意：把stack按照本测试类中的方式转成list列表，此时这里输出是1 2 3 4.
            System.out.println(i);
        }
    }
}
