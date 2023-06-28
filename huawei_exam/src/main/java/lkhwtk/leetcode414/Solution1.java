package lkhwtk.leetcode414;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 参考215题思路，建一个小根堆
 * 本题用小根堆注意一个地方，初始化的时候不能像215题那样定义了(n1,n2)->n1-n2，因为类似这种测试用例：[1,2,-2147483648]，包括了整形边界，计算会有问题。
 * 这里可以直接采用默认的方式来创建小根堆就没有计算的问题了。本算法比Solution效率已经提升了50倍，但是整体效率依然不高，耗时6ms，可以了
 */
public class Solution1 {
    public int thirdMax(int[] nums) {
        //用Set集合去重
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        //如果不存在第三大的数，就返回最大的数字
        if(set.size()<3){
            Arrays.sort(nums);
            return nums[nums.length-1];
        }
        //借助PriorityQueue构建一个小根堆，数据遍历完成后，堆中保留最大的k个元素，并且堆顶元素是最小值，最后剩余的最大k个元素的堆中，堆顶元素就是第k大
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int n:set){
            heap.add(n);
            //如果堆的大小大于3，则弹出堆顶最小元素
            if(heap.size()>3){
                //弹出堆顶元素
                heap.poll();
            }
        }
        return heap.poll();
    }
}
