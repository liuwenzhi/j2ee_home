package coder.NC41;

import java.util.HashMap;

/**
 * NC41 最长无重复子数组
 * 本题核心思路和leetcode3一致，只是字符串换成了数组
 */
public class Solution {
    public int maxLength (int[] arr) {
        // write code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 1;
        for(int start = 0, end = 0; end<arr.length ; end++){
            if(map.containsKey(arr[end])){
                //重复了
                start = Math.max(start, map.get(arr[end])+1);
                //注意：这里一定要取最大的start，不然就错误了
                //为什么？ 因为重复数字的索引很可能比start小
            }
            max = Math.max(max , end-start+1);
            map.put(arr[end],end);
        }
        return max;
    }
}
