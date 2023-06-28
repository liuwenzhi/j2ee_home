package lkhwtk.leetcode1019;

import java.util.Stack;

/**
 * 参考思路：链表中的下一个更大节点（单调栈☀）
 * 将列表中的元素值放到一个数组中，借助一个单调递减栈存放数组下标，每次取出栈顶下标元素对应的数组元素值，
 * 和原数组中的值进行比对，基于这种方式能够极大提升效率
 * 本题思路可参考402和503题目
 */
public class Solution1 {
    public int[] nextLargerNodes(ListNode head) {
        ListNode p = head;
        //初始化一个单调栈，从栈顶到栈底元素值递减
        Stack<Integer> stack = new Stack<>();
        //计算链表长度
        int m = 0;
        while (p != null) {
            m++;
            p = p.next;
        }
        p = head;
        //链表元素数组
        int[] nums = new int[m];
        //结果数组
        int[] res = new int[m];
        //将链表中元素依次放到整型数组nums中
        for (int i=0;i<m;i++) {
            nums[i] = p.val;
            p = p.next;
        }
        //遍历nums数组，读取链表中每一个元素的值，将这些值维护到单调递减栈中，如果栈顶元素比当前遍历的nums元素大，则元素直接进栈，在已有元素的基础上继续构建递减序列
        //否则将栈顶元素出栈，将栈顶元素的下一个最大元素设置为当前nums[i]，然后栈顶元素出栈，继续用下一个栈顶元素和当前nums[i]来比较。最后nums[i]入栈，到最后一个元素
        //的时候，实际上对最后一个元素的下一个最小值没有做任何处理，就是默认的0，此时如果栈里还有元素，回合nums[i]比较下，判断是否需要设置下一个最大值
        for (int i=0;i<m;i++) {
            //取栈顶元素下标对应的nums数组元素之和当前nums[i]比较，i肯定比栈顶元素值大，即数组中更加靠后
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                //添加结果数组
                res[stack.peek()] = nums[i];
                //弹出栈顶元素，该元素已经处理完了
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

}
