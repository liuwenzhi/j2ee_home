package lkhwtk.leetcode347;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // 遍历map，用最小堆保存频率最大的k个元素，注意本题设置排序的方式，map并没有出现在定义比较器的方法签名中，这种排序方式非常省事
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                //堆顶存放的是最小元素
                pq.remove();
                pq.add(key);
            }
        }
        //注意：取出最小堆中的元素每次都是去最小，给数组赋值的时候，需要从后往前
        int[] result = new int[k];
        int i = k-1;
        while (!pq.isEmpty()) {
            result[i--]=pq.remove();
        }
        return result;
    }
}
