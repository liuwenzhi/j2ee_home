package lkhwtk.leetcode219;

import java.util.HashSet;
import java.util.Set;

/**
 * 画解算法：219. 存在重复元素 II
 * 本题直接遍历求解会超时
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            //set集合里边最多只保留k个元素，如果set集合中元素数量超过了k，就每次循环中删除前边一个元素
            set.add(nums[i]);
            if(set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
