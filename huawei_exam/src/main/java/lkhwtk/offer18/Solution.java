package lkhwtk.offer18;

/**
 * 剑指 Offer 18. 删除链表的节点
 */
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val){
            head = head.next;
        }else{
            ListNode index = head;
            while(index.next!=null){
                if(index.next.val==val){
                    index.next = index.next.next;
                    break;
                }
                index = index.next;
            }
        }
        return head;
    }
}
