package lkhwtk.offer22;

/**
 * 注意单链表的定义方式，leetcode上定义单链表可以采用统一这种方式
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
