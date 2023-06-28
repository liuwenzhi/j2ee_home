package lkhwtk.mst1714;

import java.util.PriorityQueue;

/**
 * 直接使用小顶堆效率相对于大顶堆能稍微高一点
 */
public class Solution3 {
    public int[] smallestK(int[] arr, int k) {
        //加个边界条件的判断
        if (k == 0||arr.length==0) {
            return new int[0];
        }
        //创建小顶堆，元素都放进去，最后拿出前k个，效率和大顶堆差不多
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //先在堆中放数组的前k个元素
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        //最后再把堆中元素转化为数组，这里正序，逆序怎么排都没有问题
        int[] res = new int[k];
        for (int i = 0; i<k ; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
