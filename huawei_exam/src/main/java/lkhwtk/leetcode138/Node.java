package lkhwtk.leetcode138;

/**
 * 备注：random指针指向的是从左到右的节点号（0,1,2,3...）
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
