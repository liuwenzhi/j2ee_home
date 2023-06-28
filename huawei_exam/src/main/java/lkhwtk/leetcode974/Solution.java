package lkhwtk.leetcode974;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. 和可被 K 整除的子数组
 * 参考题解：官方，视频说得不错，方法参考：方法一：哈希表 + 逐一统计
 * 核心思路：计算前缀和，计算完之后用hashMap保存
 */
public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : nums) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正，这里还不能对前缀和取反，因为计算前缀和会影响后边的累加
            int modulus = (sum % k + k) % k;
            //这里没有就是取出了0，统计也是加个0，前缀和取余相同，
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;

    }
}
