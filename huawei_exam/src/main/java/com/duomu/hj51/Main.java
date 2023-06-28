package com.duomu.hj51;

import java.util.Scanner;
/**
 * 题目描述
 * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 * 链表结点定义如下：
 * struct ListNode
 * {
 * int       m_nKey;
 * ListNode* m_pNext;
 * };
 * 详细描述：
 * 接口说明
 * 原型：
 * ListNode* FindKthToTail(ListNode* pListHead, unsignedint k);
 * 输入参数：
 * ListNode* pListHead  单向链表
 * unsigned int k  倒数第k个结点
 * 输出参数（指针指向的内存区域保证有效）：
 * 无
 * 返回值：
 * 正常返回倒数第k个结点指针，异常返回空指针
 * 输入描述:
 * 输入说明
 * 1 输入链表结点个数
 * 2 输入链表的值
 * 3 输入k的值
 * 输出描述:
 * 输出一个整数
 * 示例1
 * 输入
 * 8
 * 1 2 3 4 5 6 7 8
 * 4
 * 输出
 * 5
 */

public class Main {

    /**链表头结点属性*/
    private ListNode head;

    /**链表长度，查询倒数第k个节点，需要该属性*/
    private int size;

    /**
     * 根据入参初始化单链表方法
     */
    private void initList(int size,int[] val){
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
     * 查找列表倒数第k个节点的值，直接找正数size-k的位置上具体节点信息
     */
    private int getKBackwards(int k){
        if (k == 0)
            return 0;
        if (k < 0 || k > size)
            return 0;
        //直接从head指向的列表里边输出倒数第k个节点的值
        ListNode point = head;
        k = size - k;
        while(k>0){
            point = point.next;
            k--;
        }
        return point.val;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //定义变量：链表长度大小，查找倒数第几个节点
        int size,k;
        while(scanner.hasNext()){
            size = scanner.nextInt();
            int[] val = new int[size];
            for(int i=0;i<size;i++){
                val[i] = scanner.nextInt();
            }
            Main main = new Main();
            main.initList(size,val);
            k = scanner.nextInt();
            System.out.println(main.getKBackwards(k));
        }
    }
}
