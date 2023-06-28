package com.duomu.hj51;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    /**链表头结点属性*/
    private ListNode head;

    /**链表长度，查询倒数第k个节点，需要该属性*/
    private int size;

    public Main1(int size,int[] val){
        this.size = size;
        this.head = new ListNode(val[0]);
        //定义一个point引用，最开始指向head，然后顺次向后移动，指向每一个元素
        ListNode point = head;
        for(int i=1;i<val.length;i++){
            //初始化单链表的下一个节点
            point.next = new ListNode(val[i]);
            //初始化完成之后point引用向后移动一位
            point = point.next;
        }
    }

    /**
     * 获取倒数第num个节点，对比Leetcode19题
     */
    private int getNodeByInfo(int num){
        //注意这里有一个0的情况，倒数第0个，按0算
        if(num==0){
            return 0;
        }
        /*ListNode dummy = new ListNode(-1);
        dummy.next = head;*/
        //定义左右指针都指向头结点
        ListNode left = head;
        ListNode right = head;
        //右指针向右走n-1步，走完n-1步之后，左右指针之间有n个节点（算上左右指针），正好
        for(int i=0;i<num-1;i++){
            right = right.next;
        }
        //右指针走完n步之后，左右指针同时移动，一直到右指针走到最后一位，此时左指针的next指向的就是带删除的倒数第n个节点
        while(right.next!=null){
            left = left.next;
            right = right.next;
        }
        return left.val;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            int size = Integer.parseInt(line);
            String[] temp = br.readLine().split(" ");
            int[] val = new int[size];
            for(int i=0;i<size;i++){
                val[i] = Integer.parseInt(temp[i]);
            }
            Main1 main = new Main1(size,val);
            int num = Integer.parseInt(br.readLine());
            System.out.println(main.getNodeByInfo(num));
        }
    }
}
