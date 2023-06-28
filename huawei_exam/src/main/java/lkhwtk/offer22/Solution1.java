package lkhwtk.offer22;

/**
 * 个人针对于原始设计的优化，主要是边界的控制
 */
public class Solution1 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        for(int i=0;i<k;i++){
            right = right.next;
        }
        //让right走到最后一个null节点
        while(right!=null){
            left = left.next;
            right = right.next;
        }
        return left;
    }
}
