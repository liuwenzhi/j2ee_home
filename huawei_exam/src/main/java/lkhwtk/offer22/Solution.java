package lkhwtk.offer22;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 采用双指针法，本题和面试题0202是一个思路
 * 本题作为一个标准的单链表倒数第K个节点模板
 */
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        left.next = head;
        right.next = head;
        for(int i=0;i<k;i++){
            right = right.next;
        }
        while(right.next!=null){
            left = left.next;
            right = right.next;
        }
        return left.next;
    }
}
