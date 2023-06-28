package com.duomu.hj48;

import java.util.Scanner;

/**
 * 题目描述
 * 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
 *
 * 链表结点定义如下：
 *
 * struct ListNode
 *
 * {
 *
 * int       m_nKey;
 *
 * ListNode* m_pNext;
 *
 * };
 *
 * 详细描述：
 *
 * 本题为考察链表的插入和删除知识。
 *
 * 链表的值不能重复
 *
 * 构造过程，例如
 *
 * 1 <- 2
 *
 * 3 <- 2
 *
 * 5 <- 1
 *
 * 4 <- 5
 *
 * 7 <- 2
 *
 * 最后的链表的顺序为 2 7 3 1 5 4
 *
 * 删除 结点 2
 *
 * 则结果为 7 3 1 5 4
 *
 *
 *
 * 输入描述:
 * 1 输入链表结点个数
 * 2 输入头结点的值
 * 3 按照格式插入各个结点
 * 4 输入要删除的结点的值
 *
 * 输出描述:
 * 输出删除结点后的序列，每个数后都要加空格
 *
 * 示例1
 * 输入
 * 5
 * 2
 * 3 2
 * 4 3
 * 5 2
 * 1 4
 * 3
 * 输出
 * 2 5 4 1
 */

public class Main {

    /**定义一个链表的head节点*/
    private ListNode head;

    /**
     * 构造方法初始化头结点大小和单链表长度
     */
    public Main(int val){
        this.head = new ListNode(val);
    }

    /**
     * 在单链表的node2节点之后插入node1节点，这里的设计按照题目中的顺序
     */
    private void insertNode(ListNode node1,ListNode node2){
        //从head节点开始往后找，一直找到node2节点，找到之后将node1插入到node2后边
        ListNode point = head;
        while(point.next!=null&&point.val!=node2.val){
            point = point.next;
        }
        //在插入记录的时候，通过point和tempNode两个对象标记node2和node2的next节点，然后在node2之后插入node1，node1的next节点指向原node2的next节点
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
     * 删除节点
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
            //在上一步循环之后，如果找到了要删除节点的值，则执行删除操作
            if(point.next!=null){
                point.next = point.next.next;
            }
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

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int size = scanner.nextInt();
            int headVal = scanner.nextInt();
            Main main = new Main(headVal);
            //按照本题的列表初始化方式，长度为5，接下来使用4行进行初始化
            for(int i=0;i<size-1;i++){
                ListNode node1 = new ListNode(scanner.nextInt());
                ListNode node2 = new ListNode(scanner.nextInt());
                main.insertNode(node1,node2);
            }
            //接收删除节点
            int delVal = scanner.nextInt();
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
