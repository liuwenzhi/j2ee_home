package lkhwtk.leetcode229;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 229. 求众数 II
 * 个人思路：借助map实现，时间效率偏低
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int length3 = nums.length/3;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> result = new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)>length3){
                result.add(key);
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {3,2,3};
        solution.majorityElement(nums);

    }
}
