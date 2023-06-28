package lkhwtk.offer24;

/**
 * 个人原始思路，和Solution基本一致，主要是头和尾处理方式没有Solution简单
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode before = head;
        ListNode after = head.next;
        head.next = null;
        while(after!=null){
            //每次用一个临时节点记录after.next
            ListNode tempNode = after.next;
            after.next = before;
            before = after;
            after = tempNode;
        }
        return before;
    }
}
