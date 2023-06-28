package lkhwtk.leetcode24;

/**
 * 递归思路
 * 这个参考下，重点是Solution迭代思路
 */
public class Solution1 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
