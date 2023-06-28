package lkhwtk.leetcode378;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 378. 有序矩阵中第 K 小的元素
 * 个人思路：参考了347题，时间效率较低，空间可以
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //定义一个大顶堆保存最小的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if (pq.size() < k) {
                    pq.offer(matrix[i][j]);
                } else if (pq.peek()>matrix[i][j]) {
                    //堆顶存放的是最大元素
                    pq.remove();
                    pq.offer(matrix[i][j]);
                }
            }
        }
        return pq.peek();
    }
}
