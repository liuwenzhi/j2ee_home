package lkhwtk.leetcode876;

/**
 * 876. 链表的中间结点，思路：快慢指针，之前做过类似题目了
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
