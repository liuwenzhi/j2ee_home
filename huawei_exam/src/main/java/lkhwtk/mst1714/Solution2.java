package lkhwtk.mst1714;

import java.util.PriorityQueue;

/**
 * 参考题解：【数据结构和算法】排序，最大堆，二分法等3种方式解决
 * 堆排序思路：建立一个大根堆，先放入k的元素，排序完成之后，堆顶的元素就是最大的，然后再把后边元素往里放，
 * 如果后边元素比堆顶小（注意：这里题解中说明有问题，和代码对应不上，本地已经改了），移除堆顶，加入小的元素。
 * 最后把对堆中剩余元素放到结果数组中
 * 2021年9月1日二轮刷题记录：这个效率不如直接使用小顶堆。见Solution3
 */
public class Solution2 {
    public int[] smallestK(int[] arr, int k) {
        //加个边界条件的判断
        if (k == 0||arr.length==0) {
            return new int[0];
        }
        //创建最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        //先在堆中放数组的前k个元素
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        //因为是最大堆，也就是堆顶的元素是堆中最大的，遍历数组后面元素的时候，
        //如果当前元素比堆顶元素小，就把堆顶元素给移除，然后再把当前元素放到堆中，
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        //最后再把堆中元素转化为数组，这里正序，逆序怎么排都没有问题
        int[] res = new int[k];
        for (int i = k-1; i>=0 ; i--) {
            res[i] = queue.poll();
        }
        return res;

    }
}
