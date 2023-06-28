package lkhwtk.leetcode202;

/**
 * 用快慢指针的方法判断单链表是否存在环
 * 参考2012年哈工大张岩老师给的思路，快指针一次走两步，慢指针一次走一步，如果单链表存在环，则快指针一定会追上慢指针。
 * 本题最核心的点在于对题干的分析，最终只会出现两种情况，要么结果等于1，要么会进入循环，具体分析思路参考官方说明。
 */
public class Solution1 {
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        //基于算法设计：快指针可能先走到1，或者和慢指针重合，最终是通过快指针进行结果判断
        while (fastRunner != 1 && slowRunner != fastRunner) {
            //慢指针一次走一步
            slowRunner = getNext(slowRunner);
            //快指针一次走两步
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

}
