package lkhwtk.leetcode21;

/**
 * 21. 合并两个有序链表
 * 核心思路：设置一个哨兵节点指向表头，设置一个prev指针来调整指向
 * 注意一个点：合并两个单链表的过程不是合并数组，合并数组可以不改变原来的数组，
 * 而只是生成一个新的数组，单链表是一个完整的链式结构，合并的时候会产生原来链表
 * 的结构改变，不改变原来链表结构没有必要，而且必须要拷贝新的链表出来。
 * offer25题和本题同个思路
 */
class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //哨兵节点
        ListNode merge = new ListNode();
        //调整指针
        ListNode pre = merge;
        while(l1!=null&&l2!=null){
            if(l1.val <= l2.val){
                //注意，pre没有往后走的时候，相当于merge的next是l1，
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        //把链表尾部补上
        if(l1!=null){
            pre.next = l1;
        }else{
            pre.next = l2;
        }
        //哨兵节点只在初始化和最终返回时使用
        return merge.next;
    }
}
