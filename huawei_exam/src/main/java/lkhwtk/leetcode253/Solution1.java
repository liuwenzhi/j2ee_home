package lkhwtk.leetcode253;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 基于优先队列方式实现元素的比较
 * 参考题解：Java优先队列解法
 * 堆和堆排序的相关概念：https://www.cnblogs.com/WindSun/p/11444446.html
 * java优先队列实现堆：https://www.cnblogs.com/yongh/p/9945539.html
 */
public class Solution1 {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        //按照对二维数组按照[0]进行升序排序
        Arrays.sort(intervals, (v1, v2) -> (v1[0] - v2[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int meetingCount = 0;
        for(int[] meeting : intervals){
            while(!heap.isEmpty() && meeting[0] >= heap.peek()){
                heap.poll();
            }
            heap.add(meeting[1]);
            //比对官方：这种设计也是对的，从算法的设计上来看，每次for循环末尾的位置，堆中的元素数量肯定会减少，起码是持平
            meetingCount = Math.max(meetingCount, heap.size());
        }
        return meetingCount;
    }

    public static void main(String[] args){
        Solution1 solution = new Solution1();
        int[][] interval = {{0,30},{5,10},{15,20}};
        System.out.println(solution.minMeetingRooms(interval));
    }
}
