package lkhwtk.leetcode141;

import java.util.HashSet;
import java.util.Set;
/**
 * 通过HashSet来判断，这个方式也不错
 */
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            //如果不能加入，说明加入了重复对象
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
