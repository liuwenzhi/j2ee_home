package lkhwtk.leetcode378;

import java.util.PriorityQueue;

/**
 * 本题直接用小顶堆效率偏低
 */
public class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        //直接建一个小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                pq.offer(matrix[i][j]);
            }
        }
        //小顶堆排序完之后，先让堆吐出k-1个最小元素，剩余一个就是第k小元素
        for(int i=0;i<k-1;i++){
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args){
        int[][] m = {{1,2},{1,3}};
        Solution2 solution2 = new Solution2();
        solution2.kthSmallest(m,2);
    }
}
