package lkhwtk.leetcode86;

/**
 * 86. 分隔链表
 * 参考题解：官方
 * 核心思路：从头到尾遍历head列表，然后单独维护大于x和小于x的两个链表，
 * 最后把大的拼到小的后边。
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        //小链表的头结点
        ListNode smallHead = new ListNode(-1);
        ListNode small = smallHead;
        //大链表的头结点
        ListNode bigHead = new ListNode(-1);
        ListNode big = bigHead;
        while(head!=null){
            if(head.val<x){
                small.next = head;
                small = small.next;
            }else{
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        //注意：big.next必须也要处理，不然可能会产生环
        big.next = null;
        small.next = bigHead.next;
        return smallHead.next;
    }
}
