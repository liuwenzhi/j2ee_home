package lkhwtk.leetcode697;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 个人排序思路结合官网思路，增加了对map的排序，会增加时空耗时，但是相比于Solution方案能好很多。
 * 重点参考下官网思路，map里边套数组，好想法
 */
public class Solution2 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                //修改值的之后，出现次数+1，结束位置修改成i
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                //首次加入元素记录下元素出现次数1，开始位置和结束位置都是i
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        List<Map.Entry<Integer, int[]>> items = new ArrayList<>(map.entrySet());
        items.sort((o1, o2) -> o2.getValue()[0] - o1.getValue()[0]);
        //最大值和最小距离
        int maxNum = items.get(0).getValue()[0], minLen = nums.length;
        for(Map.Entry<Integer, int[]> item:items){
            if (maxNum == item.getValue()[0]) {
                if(minLen > item.getValue()[2] - item.getValue()[1] + 1){
                    minLen = item.getValue()[2] - item.getValue()[1] + 1;
                }
            }else{
                break;
            }
        }
        return minLen;
    }
}
