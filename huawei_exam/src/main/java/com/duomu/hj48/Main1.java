package com.duomu.hj48;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 本题自测用例有问题，直接运行看结果就行
 */
public class Main1 {
    /**定义一个链表的head节点*/
    private ListNode head;

    /**
     * 构造方法初始化头结点大小和单链表长度
     */
    public Main1(int val){
        this.head = new ListNode(val);
    }

    /**
     * 在单链表的node2节点之后插入node1节点，这里的设计按照题目中的顺序
     */
    private void insertNode(ListNode node1,ListNode node2){
        //从head节点开始往后找，一直找到node2节点，找到之后将node1插入到node2后边
        ListNode point = head;
        //从head节点开始，如果当前节点不是node2的value，并且还能往后走，则往后走
        while(point.next!=null&&point.val!=node2.val){
            point = point.next;
        }
        //找到了node2节点，就是此时的point，通过point和tempNode两个对象标记node2和node2的next节点，
        //然后在node2之后插入node1，node1的next节点指向原node2的next节点，如果point是一个尾节点，则直接走else，node1放到node2后边
        if(point.next!=null){
            ListNode tempNode = point.next;
            point.next = node1;
            node1.next = tempNode;
        }else{
            //如果next2是一个尾节点，则直接让node2的next节点指向node1，直接插入，不涉及移动节点
            point.next = node1;
        }
    }

    /**
     * 删除节点，设计很巧妙，在不用哨兵指针的情况下就能删除
     */
    private void deleteNode(int val){
        //从head节点开始往后找
        ListNode point = head;
        if(point.val == val){
            //首先判断头结点，如果是删除头结点，则直接让原来指向头结点的指针指向头结点的next位置
            head = head.next;
        }else{
            //一个节点一个节点的往下找，如果next节点的值还不是要删除的节点，就继续往下走，因为链表值不能重复，要删除的节点是惟一的
            while(point.next!=null&&point.next.val!=val){
                point = point.next;
            }
            //在上一步循环之后，如果找到了要删除节点的值，则执行删除操作，这个if判断可以去掉
            if(point.next!=null){
                point.next = point.next.next;
            }
        }
    }

    /**
     * 借助哨兵节点删除单链表中的node
     */
    private void deleteNode2(int val){
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        if(dummyNode.next.val==val){
            dummyNode.next = dummyNode.next.next;
            head = dummyNode.next.next;
        }else{
            while(dummyNode.next.val!=val){
                dummyNode=dummyNode.next;
            }
            dummyNode.next = dummyNode.next.next;
        }
    }

    private void deleteNode1(int val){
        //从head节点开始往后找
        ListNode point = head;
        if(point.val == val){
            //首先判断头结点，如果是删除头结点，则直接让原来指向头结点的指针指向头结点的next位置
            head = head.next;
        }else{
            //一个节点一个节点的往下找，如果next节点的值还不是要删除的节点，就继续往下走
            while(point.next!=null){
                if(point.next.val==val){
                    point.next = point.next.next;
                    break;
                }else{
                    point = point.next;
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            String[] temp = line.split(" ");
            int[] nodeInfo = new int[temp.length];
            for(int i=0;i<nodeInfo.length;i++){
                nodeInfo[i] = Integer.parseInt(temp[i]);
            }
            //提取链表长度和头结点，链表长度可以不用管了
            //int size = nodeInfo[0];
            int headVal = nodeInfo[1];
            Main1 main = new Main1(headVal);
            //拆分的数组中，从第2位到第n-2位都是节点信息（位数从0开始算），最后一位是待删除的节点，这里条件中取-2或-1都可以
            for(int i=2;i<nodeInfo.length-2;i+=2){
                ListNode node1 = new ListNode(nodeInfo[i]);
                ListNode node2 = new ListNode(nodeInfo[i+1]);
                main.insertNode(node1,node2);
            }
            //接收删除节点
            int delVal = nodeInfo[nodeInfo.length-1];
            main.deleteNode(delVal);
            ListNode point = main.head;
            System.out.print(point.val+" ");
            while(point.next!=null){
                System.out.print(point.next.val+" ");
                point = point.next;
            }
            System.out.println();
        }
    }
}
