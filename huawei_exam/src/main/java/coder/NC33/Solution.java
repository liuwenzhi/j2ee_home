package coder.NC33;

/**
 * NC33 合并两个排序的链表
 * 本题同leetcode21题，offer25题，这个思路也可以，按照leetcode21题思路更简单一点
 */
public class Solution {
    public ListNode Merge(ListNode l1,ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        //先处理头
        ListNode head = (l1.val <= l2.val)? l1:l2;
        ListNode tail = head;
        l1 = (head == l1)? l1.next:l1;
        l2 = (head == l2)? l2.next:l2;
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 == null)? l2 : l1;
        return head;
    }
}
