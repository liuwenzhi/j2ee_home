package lkhwtk.leetcode697;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 697. 数组的度
 * 本题对map集合中元素的排序方式参考451题
 * 个人思路：效率偏低
 */
public class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
        }
        //map集合加入队列，进行按照value从小打到大排序
        List<Map.Entry<Integer, Integer>> items = new ArrayList<>(map.entrySet());
        items.sort((o1, o2) -> o2.getValue() - o1.getValue());
        //注意：出现次数最多的元素可能有多个
        int max = items.get(0).getValue();
        int result = nums.length;
        for(Map.Entry<Integer, Integer> item:items){
            if(item.getValue()==max){
                int num = item.getKey();
                int begin = 0;
                int end = nums.length-1;
                for(;begin<nums.length;begin++){
                    if(nums[begin]==num){
                        break;
                    }
                }
                for(;end>=begin;end--){
                    if(nums[end]==num){
                        break;
                    }
                }
                result = Math.min(result,end-begin+1);
            }else{
                //排序好之后，item的值不是max，则直接跳出循环，计算完了
                break;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1,2,2,3,1};
        System.out.println(solution.findShortestSubArray(nums));
    }
}
