package lkhwtk.leetcode142;

import java.util.ArrayList;
import java.util.List;

/**
 * 142. 环形链表 II
 * 个人思路：直接用List列表存放ListNode对象，判断是否有相等的情况
 * 时间复杂度有点高
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode index = head;
        while(index!=null){
            if(list.contains(index)){
                return index;
            }
            list.add(index);
            index = index.next;
        }
        return null;
    }

}
