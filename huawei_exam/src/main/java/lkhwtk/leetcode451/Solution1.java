package lkhwtk.leetcode451;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 参考题解:官方，基于最大堆排序
 *
 */
public class Solution1 {
    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for(char c : s.toCharArray()){
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        //先构建一个最大堆
        PriorityQueue<Map.Entry<Character, Integer>> items = new PriorityQueue<>(count.size(),(o1, o2) -> o2.getValue() - o1.getValue());
        //构建好堆对象之后，把count这个map集合全部放进去
        items.addAll(count.entrySet());
        StringBuilder res = new StringBuilder();
        while(!items.isEmpty()){
            //堆用完一个元素，弹出一个元素，让堆自己重新排序，下一次取的还是最大的
            Map.Entry<Character, Integer> item = items.poll();
            char key = item.getKey();
            int val = item.getValue();
            for(int i = 0; i < val; i++){
                res.append(key);
            }
        }
        return res.toString();
    }
}
