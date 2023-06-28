package lkhwtk.leetcode163;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        //如果数组长度为0
        if(nums==null||nums.length==0){
            if(lower==upper){
                result.add(lower+"");
            }else{
                result.add(lower+"->"+upper);
            }
            return result;
        }
        //处理数组开头
        int pre = lower;
        if(nums[0]-lower==1){
            result.add(lower+"");
        }else if(nums[0]-lower>1){
            result.add(lower+"->"+(nums[0]-1));
        }
        //处理数组中间
        pre = nums[0];
        for(int i=1;i<nums.length;i++){
            //数组中元素相差2才有缺失空间
            if(nums[i]-pre==2){
                result.add((pre+1)+"");
            }else if(nums[i]-pre > 2){
                result.add((pre+1)+"->"+(nums[i]-1));
            }
            pre = nums[i];
        }
        //注意：数组里边是>2，外边判断就是大于1了，因为数组里边元素是存在的，外边不存在
        if(upper-pre==1){
            result.add((pre+1)+"");
        }else if(upper-pre > 1){
            result.add((pre+1)+"->"+upper);
        }
        return result;
    }

}
