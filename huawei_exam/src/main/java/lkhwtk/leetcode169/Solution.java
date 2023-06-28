package lkhwtk.leetcode169;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 个人思路，效率偏低，嘿嘿。
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int i=0;i<length;i++){
            if(map.get(nums[i])>length/2){
                return nums[i];
            }
        }
        return -1;
    }
}
