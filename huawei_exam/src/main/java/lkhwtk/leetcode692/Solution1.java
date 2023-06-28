package lkhwtk.leetcode692;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 兰木达表达式实现思路
 */
public class Solution1 {
    public List<String> topKFrequent(String[] words, int k) {
        // key：字符串，value：出现的次数
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        // 传入 count.keySet() 对列表初始化
        List<String> candidates = new ArrayList<>(count.keySet());
        // lambda 表达式，根据题目要求「返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
        candidates.sort((w1, w2) -> count.get(w1).equals(count.get(w2)) ? w1.compareTo(w2) : count.get(w2) - count.get(w1));
        return candidates.subList(0, k);
    }
}
