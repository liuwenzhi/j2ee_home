package lkhwtk.mst0202;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 * 和之前删除单链表倒数第k个节点采用思路一致，设置双指针
 * 本题思路同offer22
 */
public class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        left.next = head;
        right.next = head;
        for(int i=0;i<k;i++){
            right = right.next;
        }
        while(right.next!=null){
            left = left.next;
            right = right.next;
        }
        return left.next.val;
    }
}
