package lkhwtk.leetcode703;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 * 核心思路：找最大第K个元素，则建一个小根堆，里边只保留K个元素，堆顶元素就是第K大的元素
 */
public class KthLargest {

    private int k;
    private PriorityQueue<Integer> queue;

    /**
     * 构造方法里边调用add方法保存元素，保证只保留k个
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>();
        for(int num:nums){
            add(num);
        }
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args){
        int[] nums = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3,nums);
        kthLargest.add(3);
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(9);
        kthLargest.add(4);

    }
}
