package lkhwtk.leetcode503;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 参考题解：动画讲解：单调栈
 * 单调栈思路，题解中图解很清晰，用一个栈维护单调递减的元素下标，遍历两遍记录
 * 核心思路就是：比如数列：6 5 4 3 2 8，6后边的元素到2单调递减，没有必要再单独遍历了，下一个更大元素都是2后边的8
 * 备注：单调栈递增或者递减是指从栈底到栈顶，是递增还是递减的，本题维护的是单调递减
 */
public class Solution1 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        //结果集合初始化为-1
        Arrays.fill(ret, -1);
        //用LinkedList模拟栈
        Deque<Integer> stack = new LinkedList<>();
        //因为是一个循环数组，这里遍历两遍，后一次遍历可能会覆盖前一次遍历的值
        for (int i = 0; i < n * 2 - 1; i++) {
            //如果栈非空，比较下栈顶元素和当前元素，栈顶元素比当前元素小，则说明栈顶元素的下一个更大元素是nums[i]，
            //此时可能有多个栈顶元素，都弹出和当前元素比较一下，peek获取栈顶元素不弹出，pop，获取栈顶元素并弹出
            //注意：因为会遍历两次，这里用i%n做一个取余，
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            //当前元素入栈，在空栈，当前元素比栈顶元素大、当前元素比栈顶元素小三种情况都要在最后入栈
            stack.push(i % n);
        }
        return ret;
    }
}
