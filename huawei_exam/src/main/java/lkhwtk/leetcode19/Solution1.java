package lkhwtk.leetcode19;

/**
 * 遍历一次得到结果的思路：定义两个指针，两个指针之间长度为n+1（两个指针所指向的节点包含这两个节点在内中间一共n+1个节点）
 * 两个指针同时往后走，当右侧的指针走到尾时，左侧的指针的next指向就是待删除节点
 */
public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //特殊情况，只有一个节点然后要删除这个节点的情况，最后一步return dummy.next就可以把这一步省了
        /*if(n==1&&head.next==null){
            return null;
        }*/
        //通过dummy节点能够保证在一次遍历的情况下删除头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //定义左右指针都指向头结点
        ListNode left = dummy;
        ListNode right = dummy;
        //右指针向右走n步，走完n步之后，左右指针之间有n+1个节点（算上左右指针），正好
        for(int i=0;i<n;i++){
            right = right.next;
        }
        //右指针走完n步之后，左右指针同时移动，一直到右指针走到最后一位，此时左指针的next指向的就是带删除的倒数第n个节点
        while(right.next!=null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        //这里不能return head的，head可能被删除掉
        return dummy.next;
    }
}
