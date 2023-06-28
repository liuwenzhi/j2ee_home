package lkhwtk.leetcode646;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2021年9月2日将之前采用堆排序没有实现的思路做完
 */
public class Solution1 {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) {
            return 0;
        }
        //按照对二维数组按照[1]进行升序排序
        Arrays.sort(pairs, (v1, v2) -> (v1[1] - v2[1]));
        //建一个大顶堆，只存放[1]的值
        PriorityQueue<Integer> allocator = new PriorityQueue<>((num1, num2) -> num2 - num1);
        //将排序后，将第一个数组的[1]的值放到优先级队列中
        allocator.add(pairs[0][1]);
        for (int i = 1; i < pairs.length; i++) {
            //后边的a比前边的b大，满足条件
            if (pairs[i][0] > allocator.peek()) {
                allocator.add(pairs[i][1]);
            }
        }
        //大顶堆的大小
        return allocator.size();
    }
}
