package lkhwtk.leetcode560;

import java.util.HashMap;
import java.util.Map;

/**
 * 参考题解：官方，核心思路：前缀和 + 哈希表优化
 * 涉及连续子数组可以考虑使用前缀和
 */
public class Solution1 {
    public int subarraySum(int[] nums, int k) {
        //count是最终结果，pre是前缀和
        int count = 0, pre = 0;
        HashMap < Integer, Integer > map = new HashMap <> ();
        //和为0，记录出现1次，这个要加上，非常重要
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}
