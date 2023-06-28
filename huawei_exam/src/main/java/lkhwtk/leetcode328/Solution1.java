package lkhwtk.leetcode328;

/**
 * 官方思路也挺绕，时间效率高，空间效率差不多，后边有兴趣参考下
 */
public class Solution1 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;

    }
}
