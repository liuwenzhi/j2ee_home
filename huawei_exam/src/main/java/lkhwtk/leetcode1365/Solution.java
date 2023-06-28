package lkhwtk.leetcode1365;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1365. 有多少小于当前数字的数字
 * 个人思路：数组排序，然后存到map中，对重复数据单独处理下（参考14行注释）
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(arr);
        //创建一个map存储小于的值，key为数组值，value是数组中比key小的个数，出现连着的相同的数字，只统计第一个就行，后边的都一样
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],i);
            }
        }
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            result[i] = map.get(nums[i]);
        }
        return result;
    }
}
