package coder.NC96;

import java.util.Deque;
import java.util.LinkedList;

/**
 * NC96 判断一个链表是否为回文结构
 * 个人思路：基于栈，思路好想，代码简单，时间效率第一点，其他思路参考面试题0206
 */
public class Solution {
    public boolean isPail (ListNode head) {
        // write code here
        Deque<ListNode> stack = new LinkedList<>();
        ListNode index = head;
        while(index!=null){
            stack.push(index);
            index = index.next;
        }
        while(head!=null){
            if(head.val!=stack.pop().val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
