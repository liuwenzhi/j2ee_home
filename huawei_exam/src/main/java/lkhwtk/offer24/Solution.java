package lkhwtk.offer24;

/**
 * 剑指 Offer 24. 反转链表
 * 核心思路：双指针法
 * 本题和leetcode206题思一个类型，采用了不同思路实现
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode before = null;
        ListNode after = head;
        //按照当前算法，一定是after走到最后一个null，if条件不能用after.next==null，这样会少一个节点
        while(after!=null){
            //每次用一个临时节点记录after.next
            ListNode tempNode = after.next;
            after.next = before;
            before = after;
            after = tempNode;
        }
        //注意：最后一定是返回before，不是after，after是一个孤立的节点
        return before;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution solution = new Solution();
        solution.reverseList(head);
    }
}
