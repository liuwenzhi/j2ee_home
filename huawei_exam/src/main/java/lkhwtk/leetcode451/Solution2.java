package lkhwtk.leetcode451;

import java.util.*;

/**
 * 本方案可以和Solution对比下，不用Map的entry，把map的key存放到list列表中，自定义排序方式的时候，通过map
 * 对象get具体的key，来比较值
 */
public class Solution2 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
        }
        List<Character> list = new ArrayList<Character>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuffer sb = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            int frequency = map.get(c);
            //有几次重复，就拼几个字符
            for (int j = 0; j < frequency; j++) {
                sb.append(c);
            }
        }
        return sb.toString();

    }
}
