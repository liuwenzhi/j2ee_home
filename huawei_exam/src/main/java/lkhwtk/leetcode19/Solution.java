package lkhwtk.leetcode19;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 遍历两次得到结果
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = head;
        int num = 1;
        while(dummy.next!=null){
            num++;
            dummy = dummy.next;
        }
        dummy = head;
        //如果只有一个节点，并且要删除这个节点则返回null
        if(num==1&&n==1){
            return null;
        }
        int del = num-n;
        //删除头节点
        if(del==0){
            return head.next;
        }
        for(int i=1;i<num-n;i++){
            dummy = dummy.next;
        }
        dummy.next = dummy.next.next;
        return head;
    }
}
