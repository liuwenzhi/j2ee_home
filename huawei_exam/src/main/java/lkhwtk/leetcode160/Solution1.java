package lkhwtk.leetcode160;

import java.util.HashSet;
import java.util.Set;

/**
 * 参考思路：官方，基于hash表实现，注意一个点：用set集合存储ListNode对象，
 * 如果在遍历列表的过程中发现一个ListNode已经被存储在了set集合中，则一定是
 * 同一个对象，这里比较的是对象本身。
 */
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = headA;
        while(dummy!=null){
            dummy = dummy.next;
            visited.add(dummy);
        }
        dummy = new ListNode(-1);
        dummy.next = headB;
        while(dummy!=null){
            //注意使用set集合判断一个元素是否存在的方式，此时判断的是是否包含一个实际的对象，如果存在，则一定是重合节点部分的起点
            dummy = dummy.next;
            if(visited.contains(dummy)){
                return dummy;
            }
        }
        return null;
    }

    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        ListNode headA = new ListNode(1);
        ListNode headB = headA;
        solution1.getIntersectionNode(headA,headB);
    }
}
