package lkhwtk.leetcode1171;

import java.util.HashMap;
import java.util.Map;

/**
 * 1171. 从链表中删去总和值为零的连续节点
 * 注意题干：给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * 关键点：总和 值为 0 的连续节点组成的序列，即：要删除的是连续的点
 * 参考题解：Java HashMap 两次遍历即可
 * 本题涉及到head节点可能也会被删除，最好是单独建立一个dummy节点，dummy节点next指针指向head，本题还有一点：
 * 因为可能从head到具体某个node的累加和是0，按照本题的算法没有0这个节点，所以前边放一个dummy值为0
 * 本题思路实际是单链表的前缀和思路，之前数组计算中有用过这个思路
 */
public class Solution {
    /*思路非常巧：比如一个链表数字是1(head) 2(node1) -3(node2) 3(node3) 1(node4)
    * 先用一个hashmap记录下链表元素累加和以及元素位置：
    * 0 dummy
    * 1 head
    * 3 node1
    * 0 node2 //map中value：dummy被覆盖
    * 3 node3 //map中value：node1倍覆盖
    * 4 node4
    * 最终map中key，value对应关系：1 head,0 node2,3 node3,4 node4
    * 然后再遍历一次链表，初始sum值依然为0，然后累加遍历的节点的val值和sum，
    * 如果这个累加值，在map中出现，则说明当前遍历的这个节点和map中对应这个值key的那个节点之间的元素和为0
    * 这里在第二次遍历的时候，依然从dummy开始，sum累加dummy的值是0，在map中对应ndoe2，则dummy的next指向了node2的next，
    * 最后返回3,1
    * 总之，核心思路就是，到各个节点的累加和，比对下是否会重复，基于第一次遍历的覆盖方式，会找到链表中
    * 最后一个重复的位置，如果之前也有重复的就直接删除了。
    * */
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();

        // 首次遍历建立 节点处链表和<->节点 哈希表
        // 若同一和出现多次会覆盖，即记录该sum出现的最后一次节点
        int sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            map.put(sum, d);
        }

        // 第二遍遍历 若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0 直接删除区间所有节点
        sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            //这里就直接把链表元素删除了，删除的节点为：当前节点不删除，当前节点的next指向了map中对应值节点的next，map中
            // 对应值key的节点也会被删除掉，然后在for循环中，直接从d.next开始往后走
            d.next = map.get(sum).next;
        }

        return dummy.next;
    }
}
