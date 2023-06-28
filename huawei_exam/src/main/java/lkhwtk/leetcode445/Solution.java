package lkhwtk.leetcode445;

/**
 * 445. 两数相加 II
 * 直接计算能通过32%的用例，主要是累加的过程中出现了超过整形最大范围的情况2147483647
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = 0, num2 = 0;
        while (l1 != null) {
            num1 = num1 * 10 + l1.val;
            l1 = l1.next;
        }
        while (l2 != null) {
            num2 = num2 * 10 + l2.val;
            l2 = l2.next;
        }
        String result = (num1 + num2) + "";
        ListNode head = null, tail = null;
        for (int i = 0; i < result.length(); i++) {
            int num = result.charAt(i) - '0';
            if (head == null) {
                head = tail = new ListNode(num);
            } else {
                tail.next = new ListNode(num);
                tail = tail.next;
            }
        }
        return head;
    }
}
