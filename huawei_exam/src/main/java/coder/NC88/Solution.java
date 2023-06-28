package coder.NC88;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * NC88 寻找第K大
 * 本题同leetcode215
 */
public class Solution {
    public int findKth(int[] a, int n, int K) {
        //建一个小根堆，当堆中元素数量超过K个，就把堆顶元素弹出，这样最后堆中保留了k个最大的元素，此时堆顶元素即为第k大元素
        //经过测试发现一个点：PriorityQueue创建的堆，默认就是小根堆，没必要自定义一个排序，自定义这个排序执行时间为100ms+,不加这个自定义排序内容，代码执行时间为22ms
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2)->n1-n2);
        for(int num:a){
            heap.add(num);
            if(heap.size()>K){
                heap.poll();
            }
        }
        return heap.poll();
    }

    /**
     * 用这种直接排序的方式，执行时间22ms
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        return nums[length-k];
    }
}
