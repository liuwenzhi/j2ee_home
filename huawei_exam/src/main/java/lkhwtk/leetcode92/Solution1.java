package lkhwtk.leetcode92;

/**
 * 92. 反转链表 II
 * 参考题解：Java-双指针-头插法
 * 官方题解交换太麻烦，有坑一直没理解，参考头插法这个思路非常棒，设置两个指针g和p，
 * g放在left前一个位置，g.next->left,直接移动到left位置，然后把p的next元素去掉，删除元素在g的next位置插入，p后移，重复这个过程，一直到right位置元素移动完成
 * 具体可以参考头插法题解
 */
public class Solution1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //定义哨兵节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        //初始化指针，g和p，g在dummy位置，让p在g的下一个位置，这样让gh和p同时移动left个位置，g就走到了left的前一个位置，p走到了left位置
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        //将指针移到相应的位置，让g和p同时走left个位置，g走到了left前一个位置，g走到了left位置
        for(int step = 0; step < left - 1; step++) {
            g = g.next; p = p.next;
        }

        // 头插法插入节点，注意i从left直接到right，不用走到right就能通过right前一个节点的next指针获取这个元素
        for (int i = left; i < right; i++) {
            //获取p的next节点，然后删掉这个节点
            ListNode removed = p.next;
            p.next = p.next.next;
            //将删掉的节点放到g的next位置
            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;
    }

}
