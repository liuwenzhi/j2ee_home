package lkhwtk.leetcode253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 253. 会议室 II
 * 参考题解：官方
 * Solution和Solution1采用同一种思路
 * 注意本题和56题的不同：56题在按照a[0]排序完之后，会涉及到对区间的合并，合并之后，区间发生了改变。本题不能直接照搬56题思路，本题没有合并，会缺少区间的比对。
 */
public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //没有会议信息，返回0个会议室，2021年9月15日三轮刷题去掉，说明中已经给了intervers数组长度范围，这个验证没有必要
        /*if (intervals.length == 0) {
            return 0;
        }*/
        //构建最小堆，官方给出这种初始方式，实际没有必要，PriorityQueue默认就是小根堆，元素11个
        /*PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(intervals.length,new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });*/
        //官方初始化优先级队列优化：只需要定义一个长度，小根堆中只存放会议结束时间
        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length);
        //将intervals数组根据[0]进行排序
        Arrays.sort(intervals,new Comparator<int[]>() {
            public int compare(final int[] a, final int[] b) {
                return a[0] - b[0];
            }
        });
        //将排序后，第一个会议的结束时间放到优先级队列中
        allocator.add(intervals[0][1]);
        //遍历剩余的会议时间信息
        for (int i = 1; i < intervals.length; i++) {
            //如果下一个会议的开始时间晚于堆中最早结束时间，则堆中根节点出队列，PriorityQueue重新调整一个最小的
            if (intervals[i][0] >= allocator.peek()) {
                //注意：此时不存在冲突，则直接出队列，存在冲突就不弹出，最后统计队列大小，实际就是存在冲突的区间数量
                allocator.poll();
            }
            //在前边涉及到从if条件中弹出操作，新的房间加入堆，同时调整小根堆的结构
            allocator.add(intervals[i][1]);
        }

        //返回小根堆（优先级队列）的大小
        return allocator.size();
    }
}
