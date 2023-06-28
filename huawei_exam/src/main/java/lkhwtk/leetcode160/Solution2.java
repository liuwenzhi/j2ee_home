package lkhwtk.leetcode160;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution1的另外一种实现方式，不用dummy节点，两种效率都不高，用dummy能稍微好一点点
 */
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode index = headA;
        while(index!=null){
            visited.add(index);
            index = index.next;
        }
        index = headB;
        while(index!=null){
            //注意使用set集合判断一个元素是否存在的方式，此时判断的是是否包含一个实际的对象，如果存在，则一定是重合节点部分的起点
            if(visited.contains(index)){
                return index;
            }
            index = index.next;
        }
        return null;
    }
}
