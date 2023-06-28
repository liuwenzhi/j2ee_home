package lkhwtk.leetcode1353;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1353. 最多可以参加的会议数目
 * 参考题解：纯粹的贪心，没用优先队列，代码简洁逐行解释（加了改进版。 参考代码
 * 参考题解：扫描算法+贪心：参考思路
 * 核心思路：根据会议开始日期排序，然后按照日期将排序后的结束日期一次加入堆中（开始早并且结束早的先开），如果当前日期已经在结束日期之后，则删除对应的堆中元素
 * 最后判断堆是否为空，当天能不能开会，能的话参加会议数量的结果自增，然后天数增加。
 */
public class Solution {
    public int maxEvents(int[][] events) {
        //首先排序：开始时间小的在前。这样是方便我们顺序遍历，把开始时间一样的都放进堆
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        //小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //结果、当前日期（天，从1开始）、events下标、events二维数组行数
        int res = 0, current = 1, i = 0, length = events.length;
        //注意：有可能i走完了，pg还不空，比如main方法中的情况
        while (i < length || !pq.isEmpty()) {
            //将开始时间等于当前时间的会议信息放到队里中，这里放的是结束时间（开始时间排完了之后，结束早的先开），
            //在下一个while循环中比对会使用，这里小根堆按照结束时间从小到大自动调整
            while (i < length && events[i][0] == current) {
                pq.offer(events[i++][1]);
            }
            //把结束时间小于开始时间的会议去掉，当前这一天，该会议已经过期了
            while (!pq.isEmpty() && pq.peek() < current) {
                pq.poll();
            }
            //堆顶元素就是在current这一天要参加的，一天只参加一个会议
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
            current++;
        }
        return res;
    }

    public static void main(String[] args){
        int[][] a = {{1,2},{2,3},{3,4},{1,2}};
        Solution solution = new Solution();
        System.out.println(solution.maxEvents(a));
    }
}
