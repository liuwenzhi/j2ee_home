package lkhwtk.leetcode148;

/**
 * 参考题解：Sort List （归并排序链表）
 * 核心思路：将链表断开两个部分，每部分排好序之后，通过归并的方式合到一块
 * 本题分隔，合并的图解说的不错
 */
public class Solution1 {
    public ListNode sortList(ListNode head) {
        //递归方法出口
        if (head == null || head.next == null) {
            return head;
        }
        //用快慢指针方式找单链表的中点，注意慢指针在头，快指针在慢指针下一个节点
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //断链，tmp是后一个链的头节点
        ListNode tmp = slow.next;
        //慢指针指向位置next断链
        slow.next = null;
        //通过递归方法继续拆分链表，把断链后的链表继续拆
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        //拆完链表之后，一层一层往回合并
        ListNode h = new ListNode(0);
        ListNode res = h;
        //拿到左右两个链表，进行合并
        while (left != null && right != null) {
            if (left.val < right.val) {
                //左侧归并到链表
                h.next = left;
                left = left.next;
            } else {
                //右侧归并到链表
                h.next = right;
                right = right.next;
            }
            //每次取到一个元素，临时指针h后移一位
            h = h.next;
        }
        //上边归并结束之后，可能左右侧链表还有剩余的元素，再合并到总链表中，因为在归并的过程中left和right都在往后走，所以这里直接接到h的next上就行了。
        h.next = left != null ? left : right;
        return res.next;

    }
}
