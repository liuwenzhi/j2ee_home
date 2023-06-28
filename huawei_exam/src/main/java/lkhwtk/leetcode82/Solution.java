package lkhwtk.leetcode82;

/**
 * 82. 删除排序链表中的重复元素 II
 * 一次遍历思路，可参考下官方题解。设置一个前置节点dummy，定义一个cur节点指向dummy，再移动cur节点往后判断就好了
 * cur一直放在一个比较节点的前置位置，比较cur.next和cur.next.next，就是本题的最大技巧所在。
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        //设置一个dummy节点，因为可能会删除头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //基于下边的while算法，cur节点实际上一直在删除节点的前置节点上，这个设计是核心
        ListNode cur = dummy;
        while(cur.next!=null&&cur.next.next!=null){
            if(cur.next.val == cur.next.next.val){
                //拿到重复值val，只要连续存在这个值，就一直删除
                int val = cur.next.val;
                while(cur.next!=null&&cur.next.val==val){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
