package lkhwtk.leetcode961;

import java.util.HashMap;
import java.util.Map;

/**
 * 961. 重复 N 次的元素
 */
public class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length/2;
        for(int num:nums){
            //这个if优化导致了弄巧成拙，判断这块耗时更多一些
            /*if(map.containsKey(num)&&map.get(num)==n){
                return num;
            }*/
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)==n){
                return key;
            }
        }
        return 0;
    }
}
