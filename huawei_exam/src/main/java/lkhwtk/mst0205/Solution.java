package lkhwtk.mst0205;

/**
 * 面试题 02.05. 链表求和
 * 链表倒着存放，表面上看有点乱，实际是简便了计算，可以从前往后遍历计算，
 * 参考代码：java简洁代码 一个循环
 * 本题同leetcode2
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //进位
        int x = 0;
        //哨兵节点，最终返回dummy.next
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        //while循环设计真实妙不可言，体现了算法一种美
        while(l1!=null||l2!=null||x>0){
            //每次循环统计一个累加和，先加上进位x，从x初始化
            int sum = x;
            if(l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            //新节点每次保留累加个位
            node.next = new ListNode(sum%10);
            //x每次保留进位
            x = sum/10;
            node = node.next;
        }
        return dummy.next;
    }
}
