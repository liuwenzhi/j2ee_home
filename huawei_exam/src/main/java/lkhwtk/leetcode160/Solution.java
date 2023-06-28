package lkhwtk.leetcode160;

/**
 * 160. 相交链表
 * 参考题解：图解相交链表
 * 本题就是玩技巧，注意一定要遍历到最后一个NULL，不然本题算法会出现死循环
 * 本题作为一个模板记一下
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode index1 = headA;
        ListNode index2 = headB;
        while(index1!=index2){
            index1=(index1==null)?headB:index1.next;
            index2=(index2==null)?headA:index2.next;
        }
        return index1;
    }
}
