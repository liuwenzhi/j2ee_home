package lkhwtk.leetcode1313;

import java.util.ArrayList;
import java.util.List;

/**
 * 1313. 解压缩编码列表
 * 个人思路，效率一般，耗时低的题解和本题思路差不多
 */
public class Solution {
    public int[] decompressRLElist(int[] nums) {
        //注意：这里初始化为ArrayList能提升1ms的效率
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length-1;){
            while(nums[i]>0){
                list.add(nums[i+1]);
                nums[i]--;
            }
            i+=2;
        }
        //按照注释这种方式返回耗时增加一倍
        //return list.stream().mapToInt(Integer::intValue).toArray();
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
