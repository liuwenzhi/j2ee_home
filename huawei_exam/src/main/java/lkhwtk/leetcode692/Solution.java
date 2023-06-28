package lkhwtk.leetcode692;

import java.util.*;

/**
 * 692. 前K个高频单词
 * 思路参考：官方解答，本题涉及到个人能够优化的代码点很多，
 * 包括map集合存放元素，复写比较器，兰木达表达式，heap堆（先不看）
 */
public class Solution {
    /*覆写集合比较器方案，可以比对下之前复写list列表比较器的方式*/
    public List<String> topKFrequent(String[] words, int k) {
        // key：字符串，value：出现的次数
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        // 传入 count.keySet() 对列表初始化
        List<String> candidates = new ArrayList<>(count.keySet());
        candidates.sort(new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                if (count.get(w1).equals(count.get(w2))) {
                    //如果出现次数相同，则按照字典排序
                    return w1.compareTo(w2);
                } else {
                    return count.get(w2) - count.get(w1);
                }
            }
        });
        //截取子列表方式
        return candidates.subList(0, k);
    }
}
