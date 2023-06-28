package lkhwtk.leetcode362;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 362. 敲击计数器
 * 参考题解：JAVA 队列 100%
 * 本题题意有点不好理解，实际难度不大
 */
public class HitCounter {

    /**内置队列，存储敲击时间戳信息*/
    private Queue<Integer> q;

    /**敲击次数*/
    private int count;

    /** Initialize your data structure here. */
    public HitCounter() {
        q = new LinkedList<>();
        count = 0;
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        //从队尾进队
        q.add(timestamp);
        count++;
    }

    /** Return the number of hits in the past 5 minutes.
     *@param timestamp - The current timestamp (in seconds granularity).
     * 核心思路：每次统计过去五分钟敲击次数的时候，把队列中超过了5分钟的记录都去掉，因为后边用不上了
     */
    public int getHits(int timestamp) {
        if(q.size() == 0){
            return 0;
        }
        int peek = q.peek();
        //注意：题目中敲击的顺序是按照时间先后来的，每次进队都是从队尾进队，队列前端的元素就是时间早敲击的
        //然后时间是五分钟，在300这个时刻，0就不统计了，注意这个边界
        while(peek <= timestamp - 300) {
            q.poll();
            count--;
            if(q.isEmpty()){
                return 0;
            }
            peek = q.peek();
        }
        return count;
    }
    public static void main(String[] args){
        HitCounter counter = new HitCounter();
        // 在时刻 1 敲击一次。
        counter.hit(1);
        // 在时刻 2 敲击一次。
        counter.hit(2);
        // 在时刻 3 敲击一次。
        counter.hit(3);
        // 在时刻 4 统计过去 5 分钟内的敲击次数, 函数返回 3 。
        System.out.println(counter.getHits(4));
        // 在时刻 300 敲击一次。
        counter.hit(300);
        // 在时刻 300 统计过去 5 分钟内的敲击次数，函数返回 4 。
        System.out.println(counter.getHits(300));
        // 在时刻 301 统计过去 5 分钟内的敲击次数，函数返回 3 。
        System.out.println(counter.getHits(301));
    }
}
