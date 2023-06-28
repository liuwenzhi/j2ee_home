package lkhwtk.leetcode445;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 参考思路：官方，借助栈来实现计算
 * 重点参考这个
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        while (l1 != null) {
            //备注：使用队列方式创建栈需要用push方法进行压栈操作，直接使用stack创建栈可以用add方法
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        //进位
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            //因stack1和stack2两个栈中存储数据量不一致，所以必须要左下空栈判断，空取0的处理
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            //这一步思路非常好，退步实现计算，每次新建current节点next指向ans，然后ans再直接指向current，ans往前移动一位
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }
}
