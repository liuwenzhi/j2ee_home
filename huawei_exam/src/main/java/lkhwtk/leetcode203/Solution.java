package lkhwtk.leetcode203;

/**
 * 203. 移除链表元素
 * 注意：待删除的节点可能是头结点，然后头结点之后有连续的几个节点，涉及到头结点，则一定要用到哨兵节点
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //定义一个哨兵节点prev，作为head节点的自定义前置，从始至终prev节点不移动，可能会改变next
        ListNode prev = new ListNode(0);
        prev.next = head;
        //当前节点，往后移动比对节点值
        ListNode curr = head;
        //前置节点，配合curr节点删除节点
        ListNode sentry = prev;
        while(curr!=null){
            if(curr.val == val){
                //删除节点的时候，前置节点不移动，直接删除
                sentry.next = curr.next;
            }else{
                //不删除节点的时候，前置哨兵后移一步，实际相当于 sentry = curr
                sentry = sentry.next;
            }
            curr = curr.next;
        }
        return prev.next;
    }
}
