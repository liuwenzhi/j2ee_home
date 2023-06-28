package lkhwtk.leetcode325;

import java.util.HashMap;
import java.util.Map;

/**
 * 325. 和等于 k 的最长子数组长度
 * 本题中说的子数组，是指连续的
 * 参考题解：和等于 k 的最长子数组长度 Java 利用HashMap保存前缀和及其索引 有注释
 */
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length;
        int max = 0;
        //求前缀和，并利用 Map<前缀和, 对应索引> 储存，存储的前缀值包括一个值没有一直到全部元素，实际统计的前缀数量是len+1
        int[] sum = new int[len + 1];
        Map<Integer, Integer> map = new HashMap<>();
        //第一个元素的前缀值为0，直接保存，可以不用这一步，具体参考Solution1的设计
        map.put(0, 0);
        for (int i = 1; i <= len; i ++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            //map中没有前缀值时存入这个值，有的话不存储，因为要返回最长子数组，肯定要保留小的数组下标编号
            if (!map.containsKey(sum[i])){
                map.put(sum[i], i);
            }
        }
        //从后向前遍历数组，i为子数组的结尾，寻找符合条件的前缀和及其索引，i> max是一步优化，直接大于0也行，
        //本题不会影响性能，这里的优化意思是：子数组已经这么长了，没有必要再去遍历比max更短的数组序列了
        for (int i = len; i > max; i --) {
            //从i到 sum[i]-k值对应这个节点之间的子数组，就是满足和为k的子数组，但是是不是最大的需要继续比较下
            if (map.containsKey(sum[i] - k)) {
                max = Math.max(max, i - map.get(sum[i] - k));
            }
        }
        return max;
    }
}
