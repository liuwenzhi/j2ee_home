package lkhwtk.leetcode2;

/**
 * 解题参考：画解算法：2. 两数相加
 *
 * 小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。
 * 使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果
 * 本题同面试题0205，标准求和模板，两数外加一个进位，因为单链表都是逆序的，所以直接从头开始遍历就行了
 */
public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //预先标记指针
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            //计算进位和余数
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        //链表计算结束后，判断下，可能还得再加一位
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
