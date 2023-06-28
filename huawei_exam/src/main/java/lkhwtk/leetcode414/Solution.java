package lkhwtk.leetcode414;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 414. 第三大的数
 */
public class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            if(list.contains(nums[i])){
                continue;
            }else{
                list.add(nums[i]);
            }
        }
        int size = list.size();
        if(size>=3){
            return list.get(2);
        }else{
            return list.get(0);
        }
    }
}
