package lkhwtk.offer25;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 本题同主栈21题
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode index = dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                index.next = l1;
                l1 = l1.next;
            }else{
                index.next = l2;
                l2 = l2.next;
            }
            index = index.next;
        }
        if(l1!=null){
            index.next = l1;
        }else if(l2!=null){
            index.next = l2;
        }
        return dummy.next;
    }

}
