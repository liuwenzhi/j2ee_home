package lkhwtk.leetcode203;

/**
 * 对Solution方案的简化，去掉一个curr指针，直接用sentry指针
 */
public class Solution1 {
    public ListNode removeElements(ListNode head, int val) {
        //定义一个哨兵节点prev，作为head节点的自定义前置，从始至终prev节点不移动，可能会改变next
        ListNode prev = new ListNode(0);
        prev.next = head;
        //前置节点，配合curr节点删除节点
        ListNode sentry = prev;
        while(sentry.next!=null){
            if(sentry.next.val == val){
                //删除节点的时候，前置节点不移动，直接删除
                sentry.next = sentry.next.next;
            }else{
                sentry = sentry.next;
            }
        }
        return prev.next;
    }

    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        //[1,2,6,3,4,5,6]
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node6 = new ListNode(6);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node66 = new ListNode(6);
        node1.next = node2;
        node2.next = node6;
        node6.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node66;
        solution1.removeElements(node1,6);
    }
}
