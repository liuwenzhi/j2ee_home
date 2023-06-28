package lkhwtk.mst0202;

public class Solution1 {
    public int kthToLast(ListNode head, int k) {
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        left.next = head;
        right.next = head;
        for(int i=0;i<=k;i++){
            right = right.next;
        }
        while(right.next!=null){
            left = left.next;
            right = right.next;
        }
        return left.val;
    }
}
