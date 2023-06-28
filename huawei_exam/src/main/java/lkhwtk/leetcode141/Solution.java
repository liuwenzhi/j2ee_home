package lkhwtk.leetcode141;

class ListNode {
   int val;
   ListNode next;
   ListNode(int x) {
       val = x;
       next = null;
   }
}

/**
 * 141. 环形链表
 * 考研时哈工大张岩老师给的思路
 * 定义两个指针，一个走的快，一个走的慢，如果单链表有环，则一定会重合
 * 快慢指针判断链表是否存在环的原理是：快指针每次都比慢指针多走一步，如果存在环，快指针肯定会追上慢指针，而且两个指针能重合
 * 本题题目说得稍微有点怪异，实际就是判断一个链表有没有环
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            //快指针一次走两步
            fast = fast.next.next;
            //慢指针一次走一步
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
