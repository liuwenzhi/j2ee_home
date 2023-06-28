package lkhwtk.leetcode215;

import java.util.PriorityQueue;

/**
 * 官方视频给的答案，很好的思路：通过构建一个小根堆来实现
 * 注意：一旦涉及维护动态数据的最大最小值，可以考虑堆
 * 堆排序过程参考：https://www.cnblogs.com/chengxiao/p/6129630.html
 * 注意每次调整堆的方式：从下到上，从左到右
 */
public class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        //借助PriorityQueue构建一个小根堆，数据遍历完成后，堆中保留最大的k个元素，并且堆顶元素是最小值，最后剩余的最大k个元素的堆中，堆顶元素就是第k大
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2)->n1-n2);
        for(int n:nums){
            heap.add(n);
            if(heap.size()>k){
                heap.poll();
            }
        }
        return heap.poll();
    }
    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(solution1.findKthLargest(nums,5));
    }
}
