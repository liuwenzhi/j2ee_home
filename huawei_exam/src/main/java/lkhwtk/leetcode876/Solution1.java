package lkhwtk.leetcode876;

/**
 * 数组思路，空间效率能更高一点，直接根据条件写死一个数组长度，
 * 计数器从1开始，最后返回t/2位置的数组元素
 */
public class Solution1 {
    public ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }
}
