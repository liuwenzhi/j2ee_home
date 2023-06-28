package lkhwtk.leetcode735;

import java.util.Stack;

/**
 * 735. 行星碰撞
 * 参考题解：官方。本题思路很特别，采用模拟一边儿的方式。仔细分析明白，这个题非常有意思。
 */
public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        //数组中元素从左到右依次入栈，然后在每次入栈的过程中，判断是否会出现碰撞
        for (int ast: asteroids) {
            loop: {
                //如果栈不空，并且新加入的元素往左移（新元素小于0），栈顶元素往右移（栈顶元素大于0），则会发生碰撞
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        //栈顶元素绝对值更小，爆炸，出栈。
                        stack.pop();
                        //注意：这里使用continue，是如果栈顶元素存在多个，都是正的，如果都比入栈负数的绝对值小，那么都出栈
                        continue;
                    } else if (stack.peek() == -ast) {
                        //栈顶元素和入栈元素绝对值一致，两颗都爆炸，栈顶元素出栈，新元素不进站
                        stack.pop();
                    }
                    //承接上边的if和else if，如果栈顶元素绝对值大于新元素，则新元素爆炸，不用进栈，这里就直接跳出loop这层循环
                    //break出loop，就一个地方，while循环外边的stack.push不能再执行了
                    break loop;
                }
                //正数或者负数不发生碰撞的情况下，入栈
                stack.push(ast);
            }
        }

        //基于栈创建结果数组，注意栈的顺序是倒着的
        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; t--) {
            ans[t] = stack.pop();
        }
        return ans;
    }
}
