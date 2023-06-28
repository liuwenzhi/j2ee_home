package lkhwtk.leetcode2;

import java.util.Stack;

/**
 * 2. 两数相加
 * 直接通过整数相加求和：直接通过整数相加求和只能通过50%的测试用例，因为可能计算结果超过了int表示的范围，
 * 造成计算精度相关的问题， int max=2147483647 int min=-2147483648
 * 链表中的节点数达到10个以上，就肯定不能继续用int进行直接计算了。
 * 2021年8月28日改为long类型进行计算，也跑不完全部用例，long型最大值：9223372036854775807，19位，题目中最后几个测试用例的长度达到了20多位
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long value1 = getListValue(l1);
        long value2 = getListValue(l2);
        return generateList(value1+value2);
    }

    /**
     * 返回List列表的每一个节点所组成的元素值，解析出来的数字相对于链表是逆序
     */
    public Long getListValue(ListNode l1){
        Stack<Integer> stack = new Stack<>();
        stack.push(l1.val);
        while(l1.next!=null){
            l1 = l1.next;
            stack.push(l1.val);
        }
        Long value = 0L;
        while(!stack.isEmpty()){
            value = value*10+stack.pop();
        }
        return value;
    }

    /**
     * 根据一个整数值创建一个列表，按照逆序存储
     */
    public ListNode generateList(Long value){
        //初始化头结点，链表中最后一个数字是头
        Long val = value%10;
        ListNode first = new ListNode(Integer.parseInt(val+""));
        //定义一个标记节点
        ListNode flag = first;
        value = value/10;
        while(value > 0){
            Long val1 = value%10;
            ListNode node = new ListNode(Integer.parseInt(val1+""));
            flag.next = node;
            flag = flag.next;
            value = value/10;
        }
        return first;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l1.next.next =l3;
        System.out.println(solution.getListValue(l1));
    }
}
