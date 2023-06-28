package lkhwtk.offer40;

import java.util.PriorityQueue;

/**
 * 基于堆排序，通过小根堆实现，把元素都入堆之后，取前K个
 */
public class Solution1 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            queue.add(arr[i]);
        }
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = queue.poll();
        }
        return result;
    }
}
