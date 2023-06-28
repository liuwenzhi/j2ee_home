package lkhwtk.leetcode83;

/**
 * 83. 删除排序链表中的重复元素
 * 画解算法：83. 删除排序链表中的重复元素 精选
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        //while条件定义的非常好，能省很多事
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
