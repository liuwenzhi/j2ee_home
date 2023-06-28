package lkhwtk.leetcode697;

import java.util.HashMap;
import java.util.Map;

/**
 * 官方思路
 */
public class Solution1 {
    public int findShortestSubArray(int[] nums) {
        //map中key为数组数值，int为一个包含三个元素的数组，元素出现次数，首次出现位置，最后一次出现位置，
        //这个初始化方式注意下，map中的int[]泛型可以不用定义int数组实际大小
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                //修改值的之后，出现次数+1，结束位置修改成i
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                //首次加入元素记录下元素出现次数1，开始位置和结束位置都是i，首次加入元素的时候对数组进行初始化
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        //最大值和最小距离
        int maxNum = 0, minLen = 0;
        //遍历map集合，一个for循环把最大值和最小距离都搞定
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            //找出现次数最大的元素
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) {
                //如果元素的出现次数相等，再找最短距离，看看这个距离能不能更小
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        /*minLen = nums.length;
        //上边遍历map的另一种实现，两个for循环，一个只统计最大值，一个找最大值的最小距离，不用计算map中每一个元素值的最小距离，实际多耗费1ms
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            //找出现次数最大的元素
            if (maxNum < arr[0]) {
                maxNum = arr[0];
            }
        }
        for(Map.Entry<Integer, int[]> entry : map.entrySet()){
            int[] arr = entry.getValue();
            //找出现次数最大的元素
            if (maxNum == arr[0]) {
                minLen = (arr[2] - arr[1] + 1)<minLen?(arr[2] - arr[1] + 1):minLen;
            }
        }*/
        return minLen;
    }
}
