package lkhwtk.leetcode24;

/**
 * 24. 两两交换链表中的节点
 * 参考题解：画解算法：24. 两两交换链表中的节点 精选
 *         官方题解
 * 本体思路很绕，非递归算法需要借助四个指针来完成，包括两个前置指针和一个start、一个end指针。
 * 之前个人通过一个start、一个end指针来做，非常不好模拟，同时算法中start和end作为每次循环
 * 中的两个临时指针，避免了第一次单独处理等情况。
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        ListNode start = null;
        ListNode end = null;
        //注意：涉及到head节点移动，最好是建一个dummy前置节点，不然单独考虑头和其他部分有点麻烦，算法核心部分是3个指针的移动
        while(temp.next != null && temp.next.next != null) {
            start = temp.next;
            end = temp.next.next;
            //第一次循环的时候，pre节点会指向第一次交换到头部的节点，即新的head节点
            temp.next = end;
            start.next = end.next;
            end.next = start;
            //temp向后移动，第一轮循环过程中，temp=start之后，temp就和pre没有关系了，是一个新的对象，pre还是指向头部
            temp = start;
        }
        return pre.next;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        solution.swapPairs(head);
    }
}
