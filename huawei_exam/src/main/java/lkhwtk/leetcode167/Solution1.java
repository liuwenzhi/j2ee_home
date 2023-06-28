package lkhwtk.leetcode167;

import java.util.HashMap;
import java.util.Map;

/**
 * 本题用第一题思路可以做，就是效率稍微低一点
 */
public class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; ++i) {
            if (hashtable.containsKey(target - numbers[i])) {
                return new int[]{hashtable.get(target - numbers[i]), i+1};
            }
            hashtable.put(numbers[i], i+1);
        }
        //题干中说了，肯定有唯一结果
        return new int[2];
    }
}
