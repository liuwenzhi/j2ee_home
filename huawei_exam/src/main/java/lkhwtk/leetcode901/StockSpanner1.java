package lkhwtk.leetcode901;

import java.util.Stack;

/**
 * 参考题解：官方
 * 核心思路：单调栈，换一个角度考虑问题，找最近一个大于今天价格的价格，然后从最大价格的下一天开始统计，
 * 不算最大价格本身这一天。用一个单调栈，维护股票价格的单调递减序列，同时再用一个栈，维护序列中每个元素
 * 与上一个元素相差的天数信息，栈中不用存放全部元素，只维护一个递减的序列即可。
 */
public class StockSpanner1 {
    Stack<Integer> prices, weights;

    public StockSpanner1() {
        prices = new Stack();
        weights = new Stack();
    }

    public int next(int price) {
        //需要加上本身
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            //比当前小的栈顶元素出栈，同时累加上这个元素到上一个元素之间的天数（算上当前元素本身，不算上一个元素本身）
            //可以这么来理解：weight栈中每一个元素保留了到上一个元素的时间，包括当前元素的时间，不包括上一个元素的时间，所以当前天数下需要把当前w累加到weight统计中
            prices.pop();
            w += weights.pop();
        }
        //单调栈设计的一个性质：每一天结束之后，会更新单调栈，将最新一天的数据维护到单调栈中
        prices.push(price);
        weights.push(w);
        return w;
    }

}
