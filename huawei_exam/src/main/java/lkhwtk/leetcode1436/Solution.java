package lkhwtk.leetcode1436;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1436. 旅行终点站
 * 参考题解：99.52% 95.37%
 * 本题思路相当不错，开始我往图的深度优先遍历方向上想，过于复杂，基于hashmap的方式非常简洁
 */
public class Solution {
    public String destCity(List<List<String>> paths) {
        //将旅行路线数组中每一个元素，以key/value对儿的方式存储到map集合中
        Map<String,String> map = new HashMap<>(paths.size());
        for(List<String> path:paths){
            map.put(path.get(0),path.get(1));
        }
        //拿到首个开始地点，基于这个地点开始找，题目中保证能找到一个不存在环路的唯一路线，所以能这么干，就是从一个起点出发，去找key中不包含的地点，就是destination
        String key = paths.get(0).get(0);
        String destination = null;
        while(map.containsKey(key)){
            destination = map.get(key);
            key = destination;
        }
        return destination;
    }
}
