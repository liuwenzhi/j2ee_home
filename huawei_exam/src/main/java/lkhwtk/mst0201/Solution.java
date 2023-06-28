package lkhwtk.mst0201;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01. 移除重复节点
 * 个人思路
 */
public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode indexNode = head;
        Set<Integer> set = new HashSet<>();
        set.add(indexNode.val);
        while(indexNode.next!=null){
            //不包含重复元素，把值键入到缓存集合中，官方思路和本人思路一致，注意注释的if是本人原始的思路，
            //后边是官方的思路，官方比本人多了这一步优化，时间优化了1ms，达到90%+，没优化50%+
            //if(!set.contains(indexNode.next.val)){
            if(set.add(indexNode.next.val)){
                indexNode = indexNode.next;
            }else{
                //包含重复元素的情况下，直接删元素，注意此时不能往后走
                indexNode.next = indexNode.next.next;
            }
        }
        //官方思路加了这一步，没有大的必要
        //indexNode.next = null;
        return head;
    }

    public static void main(String[] args){
        //[1, 2, 3, 3, 2, 1]
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution solution = new Solution();
        solution.removeDuplicateNodes(head);
    }
}
