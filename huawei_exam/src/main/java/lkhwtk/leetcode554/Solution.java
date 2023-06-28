package lkhwtk.leetcode554;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554. 砖墙
 * 结题参考：砖墙 官方
 */
public class Solution {

    public int leastBricks(List<List<Integer>> wall) {
        //列表的长度是实际砖墙的高度
        int height = wall.size();
        //用一个hashmap记录每一个砖块右侧边缘的值，除了最右侧之外
        Map<Integer, Integer> rightEdge = new HashMap<>();
        //遍历每一行砖块，把右边缘数量记录下来，最右侧除外
        for (List<Integer> widths : wall) {
            int n = widths.size();
            int sum = 0;
            //注意：最右侧的不计算，i < n-1
            for (int i = 0; i < n - 1; i++) {
                sum += widths.get(i);
                rightEdge.put(sum, rightEdge.getOrDefault(sum, 0) + 1);
            }
        }
        int maxEdgeLength = 0;
        //注意求一个Map集合最大值的方式，这是个标准模板，实际就是遍历map集合的value取最大值。
        /*for (Map.Entry<Integer, Integer> entry : rightEdge.entrySet()) {
            maxEdgeLength = Math.max(maxEdgeLength, entry.getValue());
        }*/
        /*for(int length :rightEdge.values()){
            maxEdgeLength = Math.max(maxEdgeLength, length);
        }*/
        for(int key :rightEdge.keySet()){
            maxEdgeLength = Math.max(maxEdgeLength, rightEdge.get(key));
        }
        //最后返回高度-最大边缘（除右侧边缘之外）
        return height - maxEdgeLength;
    }
}
