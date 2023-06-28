package lkhwtk.leetcode287;

import java.util.HashSet;
import java.util.Set;

/**
 * 287. 寻找重复数
 * 个人思路：效率偏低
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            if(!set.add(num)){
                return num;
            }
        }
        return -1;
    }
}
