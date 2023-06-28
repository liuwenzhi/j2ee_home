package lkhwtk.leetcode137;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. 只出现一次的数字 II
 * 借助hashmap来获取只出现一次的数据
 *
 */
public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                int value = map.get(num);
                map.put(num,value+1);
            }else{
                map.put(num,1);
            }
        }
        for(int num:nums){
            if(map.get(num)==1){
                return num;
            }
        }
        return -1;
    }
}
