package com.sike;

/**
 * 思科机试题：输入一个数组，长度大于100，输出里边第11到第20大的是个元素
 */
import java.util.PriorityQueue;
public class Main {
    public void find(int[] nums) {
        //借助PriorityQueue构建一个大根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2)->n2-n1);
        for(int n:nums){
            heap.add(n);
        }
        //弹出大根堆中前十个元素
        for(int i=0;i<10;i++){
            heap.poll();
        }
        //把11到20大的元素弹出
        for(int i=0;i<10;i++){
            System.out.println(heap.poll());
        }
    }
}
