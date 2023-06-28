package lkhwtk.leetcode1;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 本题技巧：通过hashmap存放的key：元素值，value：元素下标来找和为target的元素，只需要每次判断map中是否存在target - nums[i]的key即可
 * 本题为2021年11月8日大箴科技现场面试原题
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        //借助一个map，key存放数组中元素值，value存放数组中具体的元素下标
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target - nums[i])){
                //返回一个int型数组，初始化方式注意下
                int[] result = {i,map.get(target-nums[i])};
                return result;//return new int[] {map.get(target-nums[i]),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[0];
    }
}
