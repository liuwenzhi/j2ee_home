package coder.NC61;

import java.util.HashMap;
import java.util.Map;

/**
 * NC61 两数之和
 * 本题同leetcode第一题
 */
public class Solution {
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int cur = 0, tmp; cur < numbers.length; cur++){
            tmp = numbers[cur];
            if (map.containsKey(target - tmp)){
                return new int[] {map.get(target - tmp) + 1, cur + 1};
            }
            map.put(tmp, cur);
        }
        throw new RuntimeException("results not exits");
    }
}
