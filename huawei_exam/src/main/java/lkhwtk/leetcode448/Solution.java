package lkhwtk.leetcode448;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * 个人思路：创建一个临时数组长度为n+1，因为nums中的数字从1到n
 * 然后将nums中出现的数字nums[i]作为temp的元素下标，在temp中统计nums[i]这个下标元素出现次数
 * 最后遍历一遍temp数组，找到值为0的元素，就是nums[i]没有出现，这个下标对应值为0，temp本身的
 * 下标0不算，最后统计出值temp[i]为0的i存放到结果列表中。
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        //定义长度为nums.length+1，因为实际数组从0开始，这里要统计从1到nums.length，所以初始化长度多一位
        int[] temp = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            temp[nums[i]]++;
        }
        for(int i=1;i<temp.length;i++){
            if(temp[i]==0){
                result.add(i);
            }
        }
        return result;

    }
}
