package lkhwtk.leetcode347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 直接建一个大顶堆，保留最后k个元素,本题直接用大根堆效率能稍微高一点，应该是建小根堆的时候不断删除增加多耗时了一点
 */
public class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // 遍历map，用最小堆保存频率最大的k个元素，注意本题设置排序的方式，map并没有出现在定义比较器的方法签名中，这种排序方式非常省事
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(b) - map.get(a);
            }
        });
        for (Integer key : map.keySet()) {
            pq.add(key);
        }
        //注意：取出最小堆中的元素每次都是去最小，给数组赋值的时候，需要从后往前
        int[] result = new int[k];
        int i = 0;
        while (!pq.isEmpty()&&i<k) {
            result[i++]=pq.poll();
            //使用下边的remove方法也可以获取堆顶元素，就本题来说，效果没有影响
            //result[i++]=pq.remove();
        }
        return result;
    }
}
