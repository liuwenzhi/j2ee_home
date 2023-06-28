package lkhwtk.mst1002;

import java.util.*;

/**
 * Solution的另一种实现，不通过整形数组，直接通过Arrays.sort排序，没想到效率反而提高了
 */
public class Solution1 {
    public List<List<String>> groupAnagrams(String[] ss) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : ss) {
            char[] cs = s.toCharArray();
            //一定是要将s转成字符数组才能排序
            Arrays.sort(cs);
            //字符数组转成字符串，直接来就好
            String key = String.valueOf(cs);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        for (String key : map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }
}
