package lkhwtk.mst0203;

/**
 * 面试题 02.03. 删除中间节点
 * 核心思路：本题只给了一个链表的中间节点，没有链表头部信息，无法遍历。
 * 直接把下个节点的值拷贝到当前节点，然后删除下个节点。
 * 本题同主栈237题
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
