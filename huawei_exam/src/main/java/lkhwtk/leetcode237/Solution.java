package lkhwtk.leetcode237;

/**
 * 237. 删除链表中的节点
 * 参考题解：官方
 * 本题有点怪，只给了一个节点，没有其他信息，调用方式有点怪异
 * 本题同面试题0203
 */
public class Solution {
    public void deleteNode(ListNode node) {
        //只给了节点，用当前节点的下一个节点替代当前节点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
