package lkhwtk.leetcode362;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 参考题解：简单使用队列，代码清晰。Runtime:1 ms, faster than 100.00% o
 * 对比HitCounter，本题使用ArrayDeque，时空复杂度基本一致
 */
public class HitCounter1 {
    Queue<Integer> q;

    /**
     * Initialize your data structure here.
     */
    public HitCounter1() {
        this.q = new ArrayDeque<>();
    }

    private void clearQ(int timestamp) {
        while (!this.q.isEmpty() && this.q.peek() <= (timestamp - 300)) {
            this.q.remove();
        }
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        this.clearQ(timestamp);
        this.q.add(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        this.clearQ(timestamp);
        return this.q.size();
    }

}
