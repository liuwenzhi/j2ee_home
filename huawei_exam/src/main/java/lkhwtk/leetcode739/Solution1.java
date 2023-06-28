package lkhwtk.leetcode739;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 * 参考题解：官方视频题解，借助栈来实现
 */
public class Solution1 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int length = temperatures.length;
        int[] result = new int[length];
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty()&&temperatures[stack.peek()] < temperatures[i]){
                int index = stack.pop();
                result[index] = i-index;
            }
            stack.push(i);
        }
        return result;
    }
    public static void main(String[] args){
        Deque<Integer> stack = new ArrayDeque<>();
        //peek方法获取头，但是不删除这个头
        stack.peek();
        //获取头部元素
        stack.pop();
        //在头部位置添加1
        stack.push(1);
        //在尾部添加2，注意和push的区别
        stack.add(1);
        Solution1 solution1 = new Solution1();
        int[] a = {73, 74, 75, 71, 69, 72, 76, 73};
        solution1.dailyTemperatures(a);
    }
}
