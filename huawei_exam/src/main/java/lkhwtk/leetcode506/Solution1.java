package lkhwtk.leetcode506;

import java.util.Map;
import java.util.TreeMap;

/**
 * 参考题解：三种解法，计数排序（2 ms，100.00%），基于TreeMap实现，自动排序
 */
public class Solution1 {
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        String[] result = new String[n];
        // key 为成绩，value 为成绩在数组中的下标，TreeMap 是按照升序进行排序的
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            // 计算成绩的排名
            int ranking = n - count++;
            switch (ranking) {
                case 1:
                    result[set.getValue()] = "Gold Medal";
                    break;
                case 2:
                    result[set.getValue()] = "Silver Medal";
                    break;
                case 3:
                    result[set.getValue()] = "Bronze Medal";
                    break;
                default:
                    result[set.getValue()] = String.valueOf(ranking);
            }
        }
        return result;
    }

    public static void main(String[] args){
        int i=1;
        System.out.println(2-i++);
    }

}
