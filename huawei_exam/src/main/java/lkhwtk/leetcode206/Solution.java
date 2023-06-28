package lkhwtk.leetcode206;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
/**
 * 206. 反转链表
 * 核心思路：借助栈实现翻转
 * offer24题与本题同种类型
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode prev = head;
        while(prev != null){
            stack.push(prev);
            prev = prev.next;
        }
        //注意列表元素可能为空，栈本身也可能是空栈
        if(!stack.isEmpty()) {
            //先弹出第一个元素，然后在循环中设置这个元素的next，分成两部去做以为内弹出的是列表最后一个元素，next为null，直接取next进行下一步的赋值会报空指针异常
            head = stack.pop();
            prev = head;
            //接下来循环拼接第二个元素，注意循环中先给next进行赋值，再往下走，这就避免了最后一个元素的next是null，直接取null的next的情况。
            while (!stack.isEmpty()) {
                prev.next = stack.pop();
                prev = prev.next;
            }
            //这一步很重要，翻转后的列表最后一个元素的next必须设置为null，不然原始node节点的next值不为null，很可能会导致列表出现环
            prev.next = null;
        }
        return head;
    }
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
    }
}
