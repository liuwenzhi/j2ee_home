package lkhwtk.leetcode49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组
 * 核心思路：map+排序方式，map转list，将map的value转成list列表，如果map的value本身是一个list列表
 * 那么转成的list列表可以是列表套列表这种
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            //将原始字符串转成字符列表，然后排序，基于排序后的字符列表创建一个新的字符串作为key，将匹配的值放到这个key对应的value集合中
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        //注意这种将map的value转成list列表的方式
        return new ArrayList<List<String>>(map.values());
    }
}
